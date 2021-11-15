package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.SkillWithSpecializations
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {
    @Insert
    suspend fun insertAll(vararg skills: Skill)

    @Update
    suspend fun updateAll(vararg skills: Skill)

    @Query("SELECT * FROM skill")
    fun getAll(): Flow<List<Skill>>

    @Query("SELECT * FROM skill WHERE attributeId=:id")
    fun getAllByAttributeId(id: Long): Flow<List<Skill>>

    @Query("SELECT * FROM skill WHERE attributeId=:id")
    fun getAllWithSpecializationsByAttributeId(id: Long): Flow<List<SkillWithSpecializations>>
}