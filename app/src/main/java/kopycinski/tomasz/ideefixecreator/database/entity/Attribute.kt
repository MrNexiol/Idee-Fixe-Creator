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
