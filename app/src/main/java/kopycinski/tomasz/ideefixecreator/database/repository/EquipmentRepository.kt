package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.EquipmentDao
import kopycinski.tomasz.ideefixecreator.database.entity.Equipment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EquipmentRepository @Inject constructor(
    private val equipmentDao: EquipmentDao
) {
    suspend fun insertEquipment(equipment: Equipment) =
        equipmentDao.insertOne(equipment)

    suspend fun updateEquipment(equipment: Equipment) =
        equipmentDao.updateOne(equipment)

    fun getAll(): Flow<List<Equipment>> =
        equipmentDao.getAll()
}