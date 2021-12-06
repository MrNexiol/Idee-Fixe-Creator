package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.SkillWithSpecializations
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SkillDao : BaseDao<Skill> {
    @Query("SELECT * FROM skill")
    abstract fun getAll(): Flow<List<Skill>>

    @Query("SELECT * FROM skill WHERE attributeId=:id")
    abstract fun getAllByAttributeId(id: Long): Flow<List<Skill>>

    @Transaction
    @Query("SELECT * FROM skill WHERE attributeId=:id")
    abstract fun getAllWithSpecializationsByAttributeId(id: Long): Flow<List<SkillWithSpecializations>>
}