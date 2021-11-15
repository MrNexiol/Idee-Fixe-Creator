package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kotlinx.coroutines.flow.Flow

@Dao
interface AdvantageDao {
    @Insert
    suspend fun insertAll(vararg advantages: Advantage)

    @Update
    suspend fun updateAll(vararg advantages: Advantage)

    @Query("SELECT * FROM advantage")
    fun getAll(): Flow<List<Advantage>>
}