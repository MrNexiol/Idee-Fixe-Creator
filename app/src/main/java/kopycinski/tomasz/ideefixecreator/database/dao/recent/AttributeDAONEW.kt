package kopycinski.tomasz.ideefixecreator.database.dao.recent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW

@Dao
interface AttributeDAONEW {
    @Query("SELECT * FROM attributenew")
    suspend fun getAll(): List<AttributeNEW>

    @Insert
    suspend fun insert(items: List<AttributeNEW>)
}