package kopycinski.tomasz.ideefixecreator.database.entity.recent

import androidx.room.Entity

@Entity(primaryKeys = ["characterSheetID", "attributeID"])
data class CharacterSheetAttributeCrossRef(
    val characterSheetID: Long,
    val attributeID: Long,
    val currentLevel: Int
)
