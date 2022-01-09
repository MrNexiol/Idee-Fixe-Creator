package kopycinski.tomasz.ideefixecreator.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kopycinski.tomasz.ideefixecreator.database.AppDatabase
import kopycinski.tomasz.ideefixecreator.database.dao.*

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
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context =
        context
}