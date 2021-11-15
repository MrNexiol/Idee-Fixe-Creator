package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kopycinski.tomasz.ideefixecreator.database.entity.Equipment
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipmentDao {
    @Insert
    suspend fun insertAll(vararg equipment: Equipment)

    @Update
    suspend fun updateAll(vararg equipment: Equipment)

    @Query("SELECT * FROM equipment")
    fun getAll(): Flow<List<Equipment>>
}