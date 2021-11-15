package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.Specialization
import kotlinx.coroutines.flow.Flow

@Dao
interface SpecializationDao {
    @Insert
    suspend fun insertAll(vararg specializations: Specialization)

    @Query("SELECT * FROM specialization")
    fun getAll(): Flow<List<Specialization>>
}