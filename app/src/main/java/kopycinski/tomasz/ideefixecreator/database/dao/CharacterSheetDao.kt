package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetWithStats
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CharacterSheetDao : BaseDao<CharacterSheet> {
    @Query("SELECT * FROM charactersheet")
    abstract fun getAll(): Flow<List<CharacterSheet>>

    @Query("SELECT * FROM charactersheet WHERE characterSheetId=:id LIMIT 1")
    abstract fun getOne(id: Long): Flow<CharacterSheet>

    @Transaction
    @Query("SELECT * FROM charactersheet WHERE characterSheetId=:id LIMIT 1")
    abstract fun getWithStats(id: Long): Flow<CharacterSheetWithStats>
}