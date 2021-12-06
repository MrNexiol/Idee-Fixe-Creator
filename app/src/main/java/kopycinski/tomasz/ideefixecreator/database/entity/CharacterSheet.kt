package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterSheet(
    var name: String = "",
    var surname: String = "",
    var age: Int = 21,
    var gender: String = "",
    var nationality: String = "",
    var notes: String = "",
    var cash: Float = 0f,
    var accountMoney: Float = 0f,
    var barter: Float = 0f,
    var experience: Int = 150,

    @PrimaryKey(autoGenerate = true) val characterSheetId: Long = 0
) {
    override fun toString(): String {
        return "$name $surname ($age)"
    }

    fun secondaryData(): String {
        return "$gender, $nationality"
    }

    fun experienceString(): String {
        return "$experience PP"
    }
}
