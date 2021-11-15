package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.*
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.AttributeWithSkillsAndSpecializations
import kotlinx.coroutines.flow.Flow

@Dao
interface AttributeDao {
    @Insert
    suspend fun insertAll(vararg attributes: Attribute)

    @Update
    suspend fun updateAll(vararg attributes: Attribute)

    @Query("SELECT * FROM attribute")
    fun getAll(): Flow<List<Attribute>>

    @Query("SELECT * FROM attribute WHERE characterSheetId=:id")
    fun getAllByCharacterSheetId(id: Long): Flow<List<Attribute>>

    @Transaction
    @Query("SELECT * FROM attribute WHERE characterSheetId=:id")
    fun getAllWithSkillsAndSpecializationsByCharacterSheetId(id: Long): Flow<List<AttributeWithSkillsAndSpecializations>>
}