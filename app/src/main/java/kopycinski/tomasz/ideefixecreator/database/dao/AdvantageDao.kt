package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AdvantageDao : BaseDao<Advantage> {
    @Query("SELECT * FROM advantage")
    abstract fun getAll(): Flow<List<Advantage>>
}