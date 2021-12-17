package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CharacterSheetWithStats(
    @Embedded val characterSheet: CharacterSheet,
    @Relation(
        entity = Attribute::class,
        parentColumn = "characterSheetId",
        entityColumn = "characterSheetId"
    )
    val attributes: List<AttributeWithSkillsAndSpecializations>,
    @Relation(
        parentColumn = "characterSheetId",
        entity = Advantage::class,
        entityColumn = "advantageId",
        associateBy = Junction(
            value = CharacterSheetAdvantageCrossRef::class,
            parentColumn = "characterSheetId",
            entityColumn = "advantageId"
        )
    )
    val advantages: List<Advantage>
)
