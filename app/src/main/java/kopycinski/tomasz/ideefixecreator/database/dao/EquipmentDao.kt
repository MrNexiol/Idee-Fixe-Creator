package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.Equipment
import kotlinx.coroutines.flow.Flow

@Dao
abstract class EquipmentDao : BaseDao<Equipment>{
    @Query("SELECT * FROM equipment")
    abstract fun getAll(): Flow<List<Equipment>>
}