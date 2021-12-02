package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.entity.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao,
    private val attributeDao: AttributeDao,
    private val skillDao: SkillDao
) {
    suspend fun createCharacter() : Flow<CharacterSheetWithStats> {
        characterSheetDao.insertOne(CharacterSheet()).let { characterSheetId ->
            attributeDao.insertMany(Attribute.attributeList(characterSheetId)).let { attributeIdsList ->
                skillDao.insertMany(Skill.skillList(attributeIdsList))
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

    fun getCharacterSheetWithAttributes(id: Long): Flow<CharacterSheetWithAttributes> =
        characterSheetDao.getOneWithAttributes(id)

    fun getCharacterSheetWithStats(id: Long): Flow<CharacterSheetWithStats> =
        characterSheetDao.getWithStats(id)

    fun getAll(): Flow<List<CharacterSheet>> =
        characterSheetDao.getAll()
}