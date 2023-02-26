package yegor.cheprasov.feature_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yegor.cheprasov.feature_data.database.dao.FinishExerciseDao
import yegor.cheprasov.feature_data.repositories.ExerciseRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideExerciseRepository(
        exerciseDao: FinishExerciseDao
    ): ExerciseRepository = ExerciseRepository(exerciseDao)

}