package kopycinski.tomasz.ideefixecreator.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kopycinski.tomasz.ideefixecreator.database.AppDatabase
import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {
    @Provides
    fun provideCharacterSheetDao(appDatabase: AppDatabase): CharacterSheetDao {
        return appDatabase.characterSheetDao()
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
}