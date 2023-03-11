package yegor.cheprasov.feature_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yegor.cheprasov.feature_data.firestore.AppFirebaseStorage
import yegor.cheprasov.feature_data.firestore.AppFirestore
import yegor.cheprasov.feature_data.repositories.ExerciseRepository
import yegor.cheprasov.feature_data.usecases.ExerciseUseCase
import yegor.cheprasov.feature_data.usecases.GrammarUseCase
import yegor.cheprasov.feature_data.usecases.WordsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGrammarUseCase(
        appFirestore: AppFirestore,
        appFirebaseStorage: AppFirebaseStorage
    ): GrammarUseCase = GrammarUseCase(appFirestore, appFirebaseStorage)

    @Provides
    @Singleton
    fun provideExerciseUseCase(
        appFirestore: AppFirestore,
        exerciseRepository: ExerciseRepository
    ): ExerciseUseCase = ExerciseUseCase(appFirestore, exerciseRepository)

    @Provides
    @Singleton
    fun provideWordsUseCase(
        appFirestore: AppFirestore,
        firebaseStorage: AppFirebaseStorage
    ): WordsUseCase = WordsUseCase(appFirestore, firebaseStorage)

}