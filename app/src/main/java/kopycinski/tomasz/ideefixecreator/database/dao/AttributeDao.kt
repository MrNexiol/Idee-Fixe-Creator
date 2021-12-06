package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.AttributeWithSkillsAndSpecializations
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AttributeDao : BaseDao<Attribute> {
    @Query("SELECT * FROM attribute")
    abstract fun getAll(): Flow<List<Attribute>>

    @Query("SELECT * FROM attribute WHERE characterSheetId=:id")
    abstract fun getAllByCharacterSheetId(id: Long): Flow<List<Attribute>>

    @Transaction
    @Query("SELECT * FROM attribute WHERE characterSheetId=:id")
    abstract fun getAllWithSkillsAndSpecializationsByCharacterSheetId(id: Long): Flow<List<AttributeWithSkillsAndSpecializations>>
}