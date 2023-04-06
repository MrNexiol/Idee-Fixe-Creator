package kopycinski.tomasz.ideefixecreator.database.entity.recent

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterSheetNEW(
    val name: String,
    @PrimaryKey val characterSheetID: Long = 0
)
