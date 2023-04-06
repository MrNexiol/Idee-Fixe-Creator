package kopycinski.tomasz.ideefixecreator.database.dao.recent

import androidx.room.Dao
import androidx.room.Insert
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetNEW

@Dao
interface CharacterSheetDAONEW {
    @Insert
    suspend fun insert(characterSheetNEW: CharacterSheetNEW): Long
}