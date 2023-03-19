package kopycinski.tomasz.ideefixecreator.database.dao.recent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kopycinski.tomasz.ideefixecreator.database.entity.recent.SkillNEW

@Dao
interface SkillDAONEW {
    @Query("SELECT * FROM skillnew")
    suspend fun getAll(): List<SkillNEW>

    @Insert
    suspend fun insert(items: List<SkillNEW>)
}