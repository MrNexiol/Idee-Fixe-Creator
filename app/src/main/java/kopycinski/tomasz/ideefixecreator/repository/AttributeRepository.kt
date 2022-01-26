package kopycinski.tomasz.ideefixecreator.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import javax.inject.Inject

class AttributeRepository @Inject constructor(
    private val attributeDao: AttributeDao
) {
    suspend fun updateAttribute(attribute: Attribute) =
        attributeDao.updateOne(attribute)
}