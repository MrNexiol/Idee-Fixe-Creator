package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CharacterSheetWithAdvantages(
    @Embedded val characterSheet: CharacterSheet,
    @Relation(
        parentColumn = "characterSheetId",
        entityColumn = "advantageId",
        associateBy = Junction(CharacterSheetAdvantageCrossRef::class)
    )
    val advantages: List<Advantage>
)
