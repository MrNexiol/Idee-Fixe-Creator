package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.SpecializationDao
import kopycinski.tomasz.ideefixecreator.database.entity.Specialization
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SpecializationDaoRepository @Inject constructor(
    private val specializationDao: SpecializationDao
) {
    suspend fun insertSpecialization(specialization: Specialization) =
        specializationDao.insertOne(specialization)

    suspend fun updateSpecialization(specialization: Specialization) =
        specializationDao.updateOne(specialization)

    fun getAll(): Flow<List<Specialization>> =
        specializationDao.getAll()

    fun getAllById(id: Long): Flow<List<Specialization>> =
        specializationDao.getAllBySkillId(id)
}