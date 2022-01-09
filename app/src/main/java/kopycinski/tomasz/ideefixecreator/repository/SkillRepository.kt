package kopycinski.tomasz.ideefixecreator.repository

import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SkillRepository @Inject constructor(
    private val skillDao: SkillDao
) {
    suspend fun updateSkill(skill: Skill) =
        skillDao.updateOne(skill)

    fun getAll(): Flow<List<Skill>> =
        skillDao.getAll()
}