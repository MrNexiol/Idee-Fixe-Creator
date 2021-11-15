package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class AttributeWithSkillsAndSpecializations(
    @Embedded val attribute: Attribute,
    @Relation(
        entity = Skill::class,
        parentColumn = "attributeId",
        entityColumn = "attributeId"
    )
    val skills: List<SkillWithSpecializations>
)
