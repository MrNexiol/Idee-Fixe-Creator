package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AttributeRepository @Inject constructor(
    private val attributeDao: AttributeDao
) {
    suspend fun insertAttribute(attribute: Attribute) =
        attributeDao.insertOne(attribute)

    suspend fun updateAttribute(attribute: Attribute) =
        attributeDao.updateOne(attribute)

    fun getAttributes(): Flow<List<Attribute>> =
        attributeDao.getAll()

    fun getAttributesById(id: Long): Flow<List<Attribute>> =
        attributeDao.getAllByCharacterSheetId(id)
}