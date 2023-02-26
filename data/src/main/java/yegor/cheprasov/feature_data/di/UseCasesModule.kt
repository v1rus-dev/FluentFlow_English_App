package yegor.cheprasov.feature_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yegor.cheprasov.feature_data.firestore.AppFirebaseStorage
import yegor.cheprasov.feature_data.firestore.AppFirestore
import yegor.cheprasov.feature_data.usecases.GrammarUseCase
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

}