package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class AttributeWithSkills(
    @Embedded val attribute: Attribute,
    @Relation(
        parentColumn = "attributeId",
        entityColumn = "attributeId"
    )
    val skills: List<Skill>
)
