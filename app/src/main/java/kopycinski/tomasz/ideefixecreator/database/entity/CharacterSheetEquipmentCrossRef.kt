package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["characterSheetId", "equipmentId"])
data class CharacterSheetEquipmentCrossRef(
    val characterSheetId: Long,
    val equipmentId: Long
)
