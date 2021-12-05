package kopycinski.tomasz.ideefixecreator.database.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class Attribute(
    val characterSheetId: Long,
    val name: String,
    val description: String,
    var level: Int = 10,

    @PrimaryKey(autoGenerate = true) val attributeId: Long = 0
) {
    companion object {
        val UPGRADE_COSTS_FOR_LEVELS = mapOf(
            0 to 5, 1 to 5, 2 to 5, 3 to 5, 4 to 5,
            5 to 5, 6 to 5, 7 to 5, 8 to 5, 9 to 5,
            10 to 5, 11 to 5, 12 to 5, 13 to 10, 14 to 10,
            15 to 10, 16 to 15, 17 to 15, 18 to 15, 19 to 20,
        )

        fun attributeList(characterSheetId: Long, context: Context): List<Attribute> {
            return listOf(
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_physique),
                    context.getString(R.string.attribute_physique_desc)
                ),
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_determination),
                    context.getString(R.string.attribute_determination_desc)
                ),
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_intelligence),
                    context.getString(R.string.attribute_intelligence_desc)
                ),
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_perception),
                    context.getString(R.string.attribute_perception_desc)
                ),
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_dexterity),
                    context.getString(R.string.attribute_dexterity_desc)
                ),
                Attribute(
                    characterSheetId,
                    context.getString(R.string.attribute_agility),
                    context.getString(R.string.attribute_agility_desc)
                ),
            )
        }
    }
}
