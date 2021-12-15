package kopycinski.tomasz.ideefixecreator.database.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class Advantage(
    val name: String,
    val description: String,
    val levels: Int,
    val costs: List<Int>,
    val isPositive: Boolean,

    @PrimaryKey(autoGenerate = true) val advantageId: Long = 0
) {
    companion object {
        fun advantageList(context: Context): List<Advantage> {
            return listOf(
                Advantage(
                    context.getString(R.string.advantage_asexual),
                    context.getString(R.string.advantage_asexual_desc),
                    1,
                    listOf(2),
                    true
                ),
                Advantage(
                    context.getString(R.string.advantage_attractive),
                    context.getString(R.string.advantage_attractive_desc),
                    3,
                    listOf(3,6,9),
                    true
                )
            )
        }
    }
}
