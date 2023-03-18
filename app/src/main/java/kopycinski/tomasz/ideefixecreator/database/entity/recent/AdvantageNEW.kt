package kopycinski.tomasz.ideefixecreator.database.entity.recent

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AdvantageNEW(
    override val name: String,
    override val description: String,

    @PrimaryKey(autoGenerate = true) val advantageID: Long = 0
) : Statistic()
