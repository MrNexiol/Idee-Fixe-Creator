package kopycinski.tomasz.ideefixecreator.repository

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
    suspend fun createOrLoadCharacter(id: Long? = null) : Flow<CharacterSheetWithStats> {
        if (id != null) {
            return getCharacterSheetWithStats(id)
        } else {
            characterSheetDao.insertOne(CharacterSheet()).let { characterSheetId ->
                attributeDao.insertMany(Attribute.attributeList(characterSheetId, context)).let { attributeIdsList ->
                    skillDao.insertMany(Skill.skillList(attributeIdsList, context))
                }
                return getCharacterSheetWithStats(characterSheetId)
            }
        }
    }

    suspend fun updateCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.updateOne(characterSheet)

    fun getCharacterSheetWithStats(id: Long): Flow<CharacterSheetWithStats> =
        characterSheetDao.getWithStats(id)

    fun getAll(): Flow<List<CharacterSheet>> =
        characterSheetDao.getAll()
}