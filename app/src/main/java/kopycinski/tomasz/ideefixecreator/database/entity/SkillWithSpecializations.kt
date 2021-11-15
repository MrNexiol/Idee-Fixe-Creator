package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SkillWithSpecializations(
    @Embedded val skill: Skill,
    @Relation(
        parentColumn = "skillId",
        entityColumn = "specializationId"
    )
    val specializations: List<Specialization>
)
