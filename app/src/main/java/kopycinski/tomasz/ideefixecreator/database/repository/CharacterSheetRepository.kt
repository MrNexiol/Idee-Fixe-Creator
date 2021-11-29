package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetWithStats
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao
) {
    suspend fun createCharacter() : Flow<CharacterSheet> {
        val cid = characterSheetDao.insertOne(CharacterSheet())
        return getCharacterSheet(cid)
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