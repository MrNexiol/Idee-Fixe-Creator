package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterSheetWithAttributes(
    @Embedded val characterSheet: CharacterSheet,
    @Relation(
        parentColumn = "characterSheetId",
        entityColumn = "characterSheetId"
    )
    val attributes: List<Attribute>
)