package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetAdvantageCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AdvantageDao : BaseDao<Advantage> {
    @Insert
    abstract suspend fun insertAdvCharCrossRef(cross: CharacterSheetAdvantageCrossRef)

    @Update
    abstract suspend fun updateAdvCharCrossRef(cross: CharacterSheetAdvantageCrossRef)

    @Query("DELETE FROM charactersheetadvantagecrossref WHERE advantageId=:advantageId AND characterSheetId=:characterSheetId")
    abstract suspend fun removeAdvCharCrossRef(advantageId: Long, characterSheetId: Long)

    @Query("SELECT * FROM advantage")
    abstract fun getAll(): Flow<List<Advantage>>

    @Query("SELECT * FROM charactersheetadvantagecrossref WHERE characterSheetId=:characterSheetId")
    abstract fun getIdsAddedToCharacterSheet(characterSheetId: Long): Flow<List<CharacterSheetAdvantageCrossRef>>
}