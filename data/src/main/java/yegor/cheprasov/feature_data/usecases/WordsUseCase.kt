package yegor.cheprasov.feature_data.usecases

import android.net.Uri
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import yegor.cheprasov.feature_data.entities.ResultWords
import yegor.cheprasov.feature_data.entities.WordsEntity
import yegor.cheprasov.feature_data.entities.WordsFromFile
import yegor.cheprasov.feature_data.firestore.AppFirebaseStorage
import yegor.cheprasov.feature_data.firestore.AppFirestore
import java.io.File
import java.io.FileReader

@OptIn(ExperimentalCoroutinesApi::class)
class WordsUseCase(
    private val firestore: AppFirestore,
    private val firebaseStorage: AppFirebaseStorage
) {

    suspend fun loadWords(): Flow<List<ResultWords>> = flow {
        val snapshot = firestore.db.collection("words").get().await()
        emit(snapshot.documents.mapNotNull {
            it.toObject(WordsEntity::class.java)
        })
    }
        .flatMapLatest { list ->
            loadFromList(list)
        }.map {
            it.map {
                mapToResultWords(it)
            }
        }

    private suspend fun mapToResultWords(wordsEntity: WordsEntity): ResultWords =
        ResultWords(
            title = wordsEntity.title,
            imagePath = if (wordsEntity.imagesFolder.isNotEmpty()) {
                imgToUri(wordsEntity.imagesFolder)
            } else {
                Uri.EMPTY
            },
            words = wordsEntity.words!!
        )

    private suspend fun imgToUri(img: String): Uri {
        return firebaseStorage.wordsReference.child("images/$img/main.png").downloadUrl.await()
    }

    private suspend fun loadFromList(list: List<WordsEntity>): Flow<List<WordsEntity>> = flow {
        val result = arrayListOf<WordsEntity>()
        list.forEach { entity ->
            if (entity.fileName.isNotEmpty()) {
                Log.d("myTag", "loadFile: ${entity.fileName}")
                loadWordsFromFile(entity.fileName).collectLatest {
                    result.add(entity.copy(words = it))
                }
            } else {
                result.add(entity)
            }
        }
        emit(result)
    }

    private suspend fun loadWordsFromFile(fileName: String): Flow<WordsFromFile> = flow {
        val file = withContext(Dispatchers.IO) {
            File.createTempFile(fileName.substringBefore("."), fileName.substringAfter("."))
        }
        firebaseStorage.wordsReference.child(fileName).getFile(file).await()
        val gson = Gson()
        val fileReader = FileReader(file)
        val entity = gson.fromJson(fileReader, WordsFromFile::class.java)
        file.delete()
        fileReader.close()
        emit(entity)
    }.flowOn(Dispatchers.IO)
        .catch { emit(WordsFromFile(emptyList())) }

}