package kopycinski.tomasz.ideefixecreator.database.entity.recent

import androidx.room.Embedded
import androidx.room.Relation

data class AttributeWithLevel(
    @Embedded val junctionTable: CharacterSheetAttributeCrossRef,
    @Relation(
        parentColumn = "attributeID",
        entityColumn = "attributeID"
    )
    val attributeNEW: AttributeNEW
)
