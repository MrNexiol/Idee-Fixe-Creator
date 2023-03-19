package kopycinski.tomasz.ideefixecreator.repository

import android.content.Context
import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.dao.recent.SkillDAONEW
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.recent.SkillNEW
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SkillRepository @Inject constructor(
    private val skillDao: SkillDao,
    private val skillDAONEW: SkillDAONEW
) {
    suspend fun updateSkill(skill: Skill) =
        skillDao.updateOne(skill)

    fun getAll(): Flow<List<Skill>> =
        skillDao.getAll()

    suspend fun insert(context: Context) =
        skillDAONEW.insert(SkillNEW.skillList(context))

    suspend fun getAllNew() =
        skillDAONEW.getAll()
}