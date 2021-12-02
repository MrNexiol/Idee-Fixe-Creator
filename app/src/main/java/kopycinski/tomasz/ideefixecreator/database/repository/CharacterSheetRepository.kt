package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.entity.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao,
    private val attributeDao: AttributeDao
) {
    suspend fun createCharacter() : Flow<CharacterSheetWithStats> {
        characterSheetDao.insertOne(CharacterSheet()).let { characterSheetId ->
            attributeDao.insertMany(Attribute.attributeList(characterSheetId))
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