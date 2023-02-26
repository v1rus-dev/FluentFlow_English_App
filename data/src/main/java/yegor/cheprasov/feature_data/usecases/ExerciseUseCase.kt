package yegor.cheprasov.feature_data.usecases

import android.util.Log
import com.google.firebase.firestore.Source
import kotlinx.coroutines.tasks.await
import yegor.cheprasov.feature_data.firestore.AppFirestore
import yegor.cheprasov.feature_data.repositories.ExerciseRepository

class ExerciseUseCase(
    private val firestore: AppFirestore,
    private val exerciseRepository: ExerciseRepository
) {

    private val exerciseRef = firestore.db.collection("exercises")

    private val source = Source.CACHE

    suspend fun load() {
        val snapshot = exerciseRef.get(source).await()
        snapshot.documents.forEach {
            Log.d("myTag", "documentSnapshot: ${it}")
        }
    }

}