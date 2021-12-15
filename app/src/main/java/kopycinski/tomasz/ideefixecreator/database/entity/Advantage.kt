package kopycinski.tomasz.ideefixecreator.database.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class Advantage(
    val name: String,
    val description: String,
    val levels: String,
    val costs: Int,
    val isPositive: Boolean,

    @PrimaryKey(autoGenerate = true) val advantageId: Long = 0
) {
    companion object {
        fun advantageList(context: Context): List<Advantage> {
            return listOf(
                Advantage(
                    context.getString(R.string.advantage_asexual),
                    context.getString(R.string.advantage_asexual_desc),
                    "4",
                    2,
                    true
                )
            )
        }
    }
}
