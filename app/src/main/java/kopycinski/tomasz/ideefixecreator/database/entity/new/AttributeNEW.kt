package kopycinski.tomasz.ideefixecreator.database.entity.new

import android.content.Context
import androidx.room.Entity
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class AttributeNEW(
    override val name: String,
    override val description: String
) : Statistic() {
    companion object {
        fun attributeList(context: Context): List<AttributeNEW> {
            return listOf(
                AttributeNEW(
                    context.getString(R.string.attribute_physique),
                    context.getString(R.string.attribute_physique_desc)
                ),
                AttributeNEW(
                    context.getString(R.string.attribute_determination),
                    context.getString(R.string.attribute_determination_desc)
                ),
                AttributeNEW(
                    context.getString(R.string.attribute_intelligence),
                    context.getString(R.string.attribute_intelligence_desc)
                ),
                AttributeNEW(
                    context.getString(R.string.attribute_perception),
                    context.getString(R.string.attribute_perception_desc)
                ),
                AttributeNEW(
                    context.getString(R.string.attribute_dexterity),
                    context.getString(R.string.attribute_dexterity_desc)
                ),
                AttributeNEW(
                    context.getString(R.string.attribute_agility),
                    context.getString(R.string.attribute_agility_desc)
                )
            )
        }
    }
}