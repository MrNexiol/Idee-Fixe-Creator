package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Advantage(
    val name: String,
    val description: String,
    val levels: String,
    val upgradeCosts: Int,
    val isPositive: Boolean,

    @PrimaryKey(autoGenerate = true) val advantageId: Long = 0
) {
    companion object {
        fun advantageList(): List<Advantage> {
            return listOf(
                Advantage("Test", "Testowanie", "4", 8, true)
            )
        }
    }
}
