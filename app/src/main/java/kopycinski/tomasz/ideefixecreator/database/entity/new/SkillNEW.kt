package kopycinski.tomasz.ideefixecreator.database.entity.new

import androidx.room.Entity

@Entity
data class SkillNEW(
    override val name: String,
    override val description: String
) : Statistic()
