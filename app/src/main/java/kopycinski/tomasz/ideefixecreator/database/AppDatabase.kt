package kopycinski.tomasz.ideefixecreator.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kopycinski.tomasz.ideefixecreator.database.converters.Converters
import kopycinski.tomasz.ideefixecreator.database.dao.AdvantageDao
import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.dao.SpecializationDao
import kopycinski.tomasz.ideefixecreator.database.dao.recent.AttributeDAONEW
import kopycinski.tomasz.ideefixecreator.database.dao.recent.CharacterSheetDAONEW
import kopycinski.tomasz.ideefixecreator.database.dao.recent.SkillDAONEW
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetAdvantageCrossRef
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.Specialization
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AdvantageNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetAttributeCrossRef
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.SkillNEW

@Database(entities = [
    CharacterSheet::class,
    CharacterSheetAdvantageCrossRef::class,
    Attribute::class,
    Skill::class,
    Specialization::class,
    Advantage::class,
    AdvantageNEW::class,
    AttributeNEW::class,
    CharacterSheetNEW::class,
    CharacterSheetAttributeCrossRef::class,
    SkillNEW::class
], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterSheetDao(): CharacterSheetDao
    abstract fun attributeDao(): AttributeDao
    abstract fun skillDao(): SkillDao
    abstract fun specializationDao(): SpecializationDao
    abstract fun advantageDao(): AdvantageDao

    abstract fun attributeDAONEW(): AttributeDAONEW
    abstract fun skillDAONEW(): SkillDAONEW
    abstract fun characterSheetDAONEW(): CharacterSheetDAONEW
}