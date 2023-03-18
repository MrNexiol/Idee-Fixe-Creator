package kopycinski.tomasz.ideefixecreator.database.dao.new

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.new.AttributeNEW

@Dao
interface AttributeDAONEW {
    @Query("SELECT * FROM attributenew")
    fun getAll(): List<AttributeNEW>

    @Insert
    fun insert(items: List<AttributeNEW>)
}