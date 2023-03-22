package kopycinski.tomasz.ideefixecreator.database.entity.recent

import androidx.room.Embedded
import androidx.room.Relation

data class AttributeWithSkillsNEW(
    @Embedded val attributeNEW: AttributeNEW,
    @Relation(
        parentColumn = "attributeID",
        entityColumn = "attributeID"
    )
    val skillList: List<SkillNEW>
)