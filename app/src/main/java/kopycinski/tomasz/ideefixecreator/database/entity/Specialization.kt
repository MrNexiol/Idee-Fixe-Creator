package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Specialization(
    val skillId: Long,
    val name: String,
    val description: String,
    var level: Int = 8,
    var upgradeCost: Int = 1,

    @PrimaryKey(autoGenerate = true) val specializationId: Long = 0
)
