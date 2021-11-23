package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AdvantageDao
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdvantageRepository @Inject constructor(
    private val advantageDao: AdvantageDao
) {
    suspend fun insertAdvantage(advantage: Advantage) =
        advantageDao.insertOne(advantage)

    suspend fun updateAdvantage(advantage: Advantage) =
        advantageDao.updateOne(advantage)

    fun getAdvantages(): Flow<List<Advantage>> =
        advantageDao.getAll()
}