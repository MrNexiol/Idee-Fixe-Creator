package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(primaryKeys = ["characterSheetId", "advantageId"], indices = [Index(value = ["advantageId"])])
data class CharacterSheetAdvantageCrossRef(
    val characterSheetId: Long,
    val advantageId: Long,
    var level: Int,
    var cost: Int
)
