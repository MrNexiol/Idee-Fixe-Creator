package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SkillRepository @Inject constructor(
    private val skillDao: SkillDao
) {
    suspend fun insertSkill(skill: Skill) =
        skillDao.insertAll(skill)

    suspend fun updateSkill(skill: Skill) =
        skillDao.updateAll(skill)

    fun getAll(): Flow<List<Skill>> =
        skillDao.getAll()

    fun getAllById(id: Long): Flow<List<Skill>> =
        skillDao.getAllByAttributeId(id)
}