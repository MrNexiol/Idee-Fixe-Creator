package kopycinski.tomasz.ideefixecreator.database.converters

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun listToString(list: List<Int>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun stringToList(text: String): List<Int> {
        return text.split(",").map { it.toInt() }
    }
}