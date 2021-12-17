package kopycinski.tomasz.ideefixecreator.database.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class Advantage(
    val name: String,
    val description: String,
    val costs: List<Int>,
    val isPositive: Boolean = true,

    @PrimaryKey(autoGenerate = true) val advantageId: Long = 0
) {
    fun calculateCost(actualLevel: Int, currentLevel: Int): Int {
        return if (actualLevel != -1) {
            if (actualLevel < currentLevel) costs[currentLevel] - costs[actualLevel] else 0
        } else costs[currentLevel]
    }

    companion object {
        fun advantageList(context: Context): List<Advantage> {
            return listOf(
                Advantage(
                    context.getString(R.string.advantage_asexual),
                    context.getString(R.string.advantage_asexual_desc),
                    listOf(2)
                ),
                Advantage(
                    context.getString(R.string.advantage_attractive),
                    context.getString(R.string.advantage_attractive_desc),
                    listOf(3,6,9)
                ),
                Advantage(
                    context.getString(R.string.advantage_androgynic),
                    context.getString(R.string.advantage_androgynic_desc),
                    listOf(3)
                ),
                Advantage(
                    context.getString(R.string.advantage_no_allergies),
                    context.getString(R.string.advantage_no_allergies_desc),
                    listOf(2)
                ),
                Advantage(
                    context.getString(R.string.advantage_intuition),
                    context.getString(R.string.advantage_intuition_desc),
                    listOf(20)
                ),
                Advantage(
                    context.getString(R.string.advantage_dual_wield),
                    context.getString(R.string.advantage_dual_wield_desc),
                    listOf(4)
                ),
                Advantage(
                    context.getString(R.string.advantage_sense_of_time),
                    context.getString(R.string.advantage_sense_of_time_desc),
                    listOf(2)
                ),
                Advantage(
                    context.getString(R.string.advantage_common_sense),
                    context.getString(R.string.advantage_common_sense_desc),
                    listOf(7)
                ),
                Advantage(
                    context.getString(R.string.advantage_bad_feeling),
                    context.getString(R.string.advantage_bad_feeling_desc),
                    listOf(20)
                )
            )
        }
    }
}
