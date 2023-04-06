package kopycinski.tomasz.ideefixecreator.repository

import android.content.Context
import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.recent.AttributeDAONEW
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetAttributeCrossRef
import javax.inject.Inject

class AttributeRepository @Inject constructor(
    private val attributeDao: AttributeDao,
    private val attributeDAONEW: AttributeDAONEW
) {
    suspend fun updateAttribute(attribute: Attribute) =
        attributeDao.updateOne(attribute)

    suspend fun insertAttributes(context: Context) =
        attributeDAONEW.insert(AttributeNEW.attributeList(context))

    suspend fun getAll() =
        attributeDAONEW.getAll()

    suspend fun getAllWithSkills() =
        attributeDAONEW.getAllWithSkills()


    suspend fun insertAttributeCharacterSheetCrossRef(item: CharacterSheetAttributeCrossRef) =
        attributeDAONEW.insertCharacterSheetCrossRef(item)

    suspend fun getAllByCharId(id: Long) = attributeDAONEW.getAllByID(id)
}