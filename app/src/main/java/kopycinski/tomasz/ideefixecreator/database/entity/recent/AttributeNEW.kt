package kopycinski.tomasz.ideefixecreator.database.entity.recent

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class AttributeNEW(
    @PrimaryKey val attributeID: Long,
    override val name: String,
    override val description: String,
    override val baseLevel: Int
) : Statistic() {
    companion object {

        const val PHYSIQUE_ID: Long = 1
        const val DETERMINATION_ID: Long = 2
        const val INTELLIGENCE_ID: Long = 3
        const val PERCEPTION_ID: Long = 4
        const val DEXTERITY_ID: Long = 5
        const val AGILITY_ID: Long = 6
        const val ATTRIBUTE_BASE_LEVEL: Int = 10

        fun attributeList(context: Context): List<AttributeNEW> {
            return listOf(
                AttributeNEW(
                    PHYSIQUE_ID,
                    context.getString(R.string.attribute_physique),
                    context.getString(R.string.attribute_physique_desc),
                    ATTRIBUTE_BASE_LEVEL
                ),
                AttributeNEW(
                    DETERMINATION_ID,
                    context.getString(R.string.attribute_determination),
                    context.getString(R.string.attribute_determination_desc),
                    ATTRIBUTE_BASE_LEVEL
                ),
                AttributeNEW(
                    INTELLIGENCE_ID,
                    context.getString(R.string.attribute_intelligence),
                    context.getString(R.string.attribute_intelligence_desc),
                    ATTRIBUTE_BASE_LEVEL
                ),
                AttributeNEW(
                    PERCEPTION_ID,
                    context.getString(R.string.attribute_perception),
                    context.getString(R.string.attribute_perception_desc),
                    ATTRIBUTE_BASE_LEVEL
                ),
                AttributeNEW(
                    DEXTERITY_ID,
                    context.getString(R.string.attribute_dexterity),
                    context.getString(R.string.attribute_dexterity_desc),
                    ATTRIBUTE_BASE_LEVEL
                ),
                AttributeNEW(
                    AGILITY_ID,
                    context.getString(R.string.attribute_agility),
                    context.getString(R.string.attribute_agility_desc),
                    ATTRIBUTE_BASE_LEVEL
                )
            )
        }
    }
}