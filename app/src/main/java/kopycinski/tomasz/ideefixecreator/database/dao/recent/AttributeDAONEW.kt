package kopycinski.tomasz.ideefixecreator.database.dao.recent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeWithLevel
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeWithSkillsNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetAttributeCrossRef

@Dao
interface AttributeDAONEW {
    @Query("SELECT * FROM attributenew")
    suspend fun getAll(): List<AttributeNEW>

    @Insert
    suspend fun insert(items: List<AttributeNEW>)

    @Transaction
    @Query("SELECT * FROM attributenew")
    suspend fun getAllWithSkills(): List<AttributeWithSkillsNEW>

    @Insert
    suspend fun insertCharacterSheetCrossRef(item: CharacterSheetAttributeCrossRef)

    @Transaction
    @Query("SELECT * FROM charactersheetattributecrossref WHERE characterSheetID = :characterSheetId")
    suspend fun getAllByID(characterSheetId: Long): List<AttributeWithLevel>
}