package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.*
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetWithAttributes
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetWithStats
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterSheetDao {
    @Insert
    suspend fun insertAll(vararg characterSheets: CharacterSheet)

    @Update
    suspend fun updateAll(vararg characterSheets: CharacterSheet)

    @Query("SELECT * FROM charactersheet")
    fun getAll(): Flow<List<CharacterSheet>>

    @Transaction
    @Query("SELECT * FROM charactersheet")
    fun getAllWithAttributes(): Flow<List<CharacterSheetWithAttributes>>

    @Query("SELECT * FROM charactersheet WHERE characterSheetId=:id LIMIT 1")
    fun getOne(id: Long): Flow<CharacterSheet>

    @Transaction
    @Query("SELECT * FROM charactersheet WHERE characterSheetId=:id LIMIT 1")
    fun getWithStats(id: Long): Flow<CharacterSheetWithStats>
}