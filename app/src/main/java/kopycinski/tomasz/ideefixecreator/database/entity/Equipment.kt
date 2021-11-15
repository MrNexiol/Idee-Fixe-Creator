package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipment(
    val name: String,
    val description: String,
    val cost: Float,
    val weight: Float,
    val availability: String,
    val concealability: String,

    @PrimaryKey(autoGenerate = true) val equipmentId: Long = 0
)
