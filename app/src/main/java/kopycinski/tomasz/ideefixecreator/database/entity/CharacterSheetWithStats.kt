package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterSheetWithStats(
    @Embedded val characterSheet: CharacterSheet,
    @Relation(
        entity = Attribute::class,
        parentColumn = "characterSheetId",
        entityColumn = "characterSheetId"
    )
    val attributes: List<AttributeWithSkillsAndSpecializations>
)
