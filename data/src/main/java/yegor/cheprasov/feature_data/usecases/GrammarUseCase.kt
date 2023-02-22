package yegor.cheprasov.feature_data.usecases

import com.google.firebase.firestore.QuerySnapshot
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import yegor.cheprasov.feature_data.entities.GrammarDetailEntity
import yegor.cheprasov.feature_data.entities.GrammarEntity
import yegor.cheprasov.feature_data.firestore.AppFirebaseStorage
import yegor.cheprasov.feature_data.firestore.AppFirestore
import java.io.File
import java.io.FileReader

class GrammarUseCase(
    private val firestore: AppFirestore,
    private val firebaseStorage: AppFirebaseStorage
) {

    suspend fun loadGrammars() = flow {
        val snapshot: QuerySnapshot = firestore.db.collection("grammars").get().await()
        emit(snapshot.documents.mapNotNull { it.toObject(GrammarEntity::class.java) })
    }

    fun loadGrammarFile(fileName: String): Flow<GrammarDetailEntity> = flow {
        val file = withContext(Dispatchers.IO) {
            File.createTempFile(fileName.substringBefore("."), fileName.substringAfter("."))
        }
        firebaseStorage.grammarReference.child(fileName).getFile(file).await()
        val gson = Gson()
        val fileReader = FileReader(file)
        val entity = gson.fromJson(fileReader, GrammarDetailEntity::class.java)
        file.delete()
        fileReader.close()
        emit(entity)
    }
        .flowOn(Dispatchers.IO)

}