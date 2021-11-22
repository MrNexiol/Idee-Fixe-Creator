package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterSheet(
    var name: String = "",
    var surname: String = "",
    var age: Int = 21,
    var gender: String = "",
    var notes: String = "",
    var cash: Float = 0f,
    var accountMoney: Float = 0f,
    var barter: Float = 0f,
    var experience: Int = 0,

    @PrimaryKey(autoGenerate = true) val characterSheetId: Long = 0
)
