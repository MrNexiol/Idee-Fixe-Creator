package kopycinski.tomasz.ideefixecreator.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kopycinski.tomasz.ideefixecreator.database.dao.*
import kopycinski.tomasz.ideefixecreator.database.entity.*

@Database(entities = [
    CharacterSheet::class,
    CharacterSheetAdvantageCrossRef::class,
    CharacterSheetEquipmentCrossRef::class,
    Attribute::class,
    Skill::class,
    Specialization::class,
    Advantage::class,
    Equipment::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterSheetDao(): CharacterSheetDao
    abstract fun attributeDao(): AttributeDao
    abstract fun skillDao(): SkillDao
    abstract fun specializationDao(): SpecializationDao
    abstract fun advantageDao(): AdvantageDao
    abstract fun equipmentDao(): EquipmentDao
}