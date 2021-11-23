package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.Specialization
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SpecializationDao : BaseDao<Specialization> {
    @Query("SELECT * FROM specialization")
    abstract fun getAll(): Flow<List<Specialization>>

    @Query("SELECT * FROM specialization WHERE skillId=:id")
    abstract fun getAllBySkillId(id: Long): Flow<List<Specialization>>
}