package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["characterSheetId", "advantageId"])
data class CharacterSheetAdvantageCrossRef(
    val characterSheetId: Long,
    val advantageId: Long
)
