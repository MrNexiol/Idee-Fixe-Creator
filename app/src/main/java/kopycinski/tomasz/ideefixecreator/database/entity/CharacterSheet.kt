package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterSheet(
    var names: String = "",
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
        return "${nameString()} ${surnameString()} ($age)"
    }

    fun experienceString(): String {
        return "$experience PP"
    }

    private fun nameString(): String {
        return if (names != "") names else "John"
    }

    private fun surnameString(): String {
        return if (surname != "") surname else "Doe"
    }

    fun genderString(): String {
        return if (gender != "") gender else "Płeć nieznana"
    }
}
