package kopycinski.tomasz.ideefixecreator.database.repository

import android.content.Context
import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.entity.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao,
    private val attributeDao: AttributeDao,
    private val skillDao: SkillDao,
    private val context: Context
) {
    suspend fun createCharacter() : Flow<CharacterSheetWithStats> {
        characterSheetDao.insertOne(CharacterSheet()).let { characterSheetId ->
            attributeDao.insertMany(Attribute.attributeList(characterSheetId, context)).let { attributeIdsList ->
                skillDao.insertMany(Skill.skillList(attributeIdsList, context))
            }
            return getCharacterSheetWithStats(characterSheetId)
        }
    }

    suspend fun insertCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.insertOne(characterSheet)

    suspend fun updateCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.updateOne(characterSheet)

    suspend fun deleteCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.deleteOne(characterSheet)

    private fun getCharacterSheet(id: Long): Flow<CharacterSheet> =
        characterSheetDao.getOne(id)

    fun getCharacterSheetWithStats(id: Long): Flow<CharacterSheetWithStats> =
        characterSheetDao.getWithStats(id)

    fun getAll(): Flow<List<CharacterSheet>> =
        characterSheetDao.getAll()
}