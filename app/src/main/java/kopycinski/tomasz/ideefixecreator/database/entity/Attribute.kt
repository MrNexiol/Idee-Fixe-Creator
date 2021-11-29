package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Attribute(
    val characterSheetId: Long,
    val name: String,
    val description: String,
    var level: Int = 8,

    @PrimaryKey(autoGenerate = true) val attributeId: Long = 0
) {
    companion object {
        fun attributeList(characterSheetId: Long): List<Attribute> {
            return listOf(
                Attribute(characterSheetId, "Budowa", "No budowa no"),
                Attribute(characterSheetId, "Determinacja", "No determinacja no"),
                Attribute(characterSheetId, "Intelekt", "No intelekt no"),
                Attribute(characterSheetId, "Percepcja", "No percepcja no"),
                Attribute(characterSheetId, "Zręczność", "No zręczność no"),
                Attribute(characterSheetId, "Zwinność", "No zwinność no"),
            )
        }
    }
}
