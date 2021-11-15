package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CharacterSheetWithEquipment(
    @Embedded val characterSheet: CharacterSheet,
    @Relation(
        parentColumn = "characterSheetId",
        entityColumn = "equipmentId",
        associateBy = Junction(CharacterSheetEquipmentCrossRef::class)
    )
    val equipment: List<Equipment>
)
