package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Advantage(
    val name: String,
    val description: String,
    val levels: String,
    val upgradeCosts: String,
    val isPositive: Boolean,

    @PrimaryKey(autoGenerate = true) val advantageId: Long = 0
)
