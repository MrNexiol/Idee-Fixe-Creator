package kopycinski.tomasz.ideefixecreator.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {
    @Insert
    suspend fun insertOne(obj: T): Long

    @Insert
    suspend fun insertMany(objects: List<T>)

    @Update
    suspend fun updateOne(obj: T)

    @Update
    suspend fun updateMany(objects: List<T>)

    @Delete
    suspend fun deleteOne(obj: T)

    @Delete
    suspend fun deleteMany(objects: List<T>)
}