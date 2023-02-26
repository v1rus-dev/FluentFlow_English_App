package yegor.cheprasov.feature_data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import yegor.cheprasov.feature_data.database.AppDatabase
import yegor.cheprasov.feature_data.database.dao.FinishExerciseDao
import javax.inject.Singleton

const val DATABASE_NAME = "fluentflow_database"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .build()

    @Provides
    @Singleton
    fun provideFinishExerciseDao(
        appDatabase: AppDatabase
    ): FinishExerciseDao = appDatabase.finishExerciseDao()

}