package kopycinski.tomasz.ideefixecreator.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kopycinski.tomasz.ideefixecreator.database.AppDatabase
import kopycinski.tomasz.ideefixecreator.database.dao.AdvantageDao
import kopycinski.tomasz.ideefixecreator.database.dao.AttributeDao
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.dao.SkillDao
import kopycinski.tomasz.ideefixecreator.database.dao.SpecializationDao
import kopycinski.tomasz.ideefixecreator.database.dao.recent.AttributeDAONEW
import kopycinski.tomasz.ideefixecreator.database.dao.recent.SkillDAONEW
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    fun provideCharacterSheetDao(appDatabase: AppDatabase): CharacterSheetDao =
        appDatabase.characterSheetDao()

    @Provides
    fun provideAdvantageDao(appDatabase: AppDatabase): AdvantageDao =
        appDatabase.advantageDao()

    @Provides
    fun provideAttributeDao(appDatabase: AppDatabase): AttributeDao =
        appDatabase.attributeDao()

    @Provides
    fun provideSkillDao(appDatabase: AppDatabase): SkillDao =
        appDatabase.skillDao()

    @Provides
    fun provideSpecializationDao(appDatabase: AppDatabase): SpecializationDao =
        appDatabase.specializationDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context =
        context




    @Provides
    fun provideAttributeDaoNew(appDatabase: AppDatabase): AttributeDAONEW =
        appDatabase.attributeDAONEW()

    @Provides
    fun provideSkillDaoNew(appDatabase: AppDatabase): SkillDAONEW =
        appDatabase.skillDAONEW()
}