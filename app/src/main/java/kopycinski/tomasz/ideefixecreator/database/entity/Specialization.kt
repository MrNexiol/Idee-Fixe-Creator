package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Specialization(
    val name: String,
    val description: String,
    val level: Int = 8,
    val upgradeCost: Int = 1,

    @PrimaryKey(autoGenerate = true) val specializationId: Long = 0
)
