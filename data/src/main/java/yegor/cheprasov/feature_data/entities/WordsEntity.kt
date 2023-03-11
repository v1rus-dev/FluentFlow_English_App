package yegor.cheprasov.feature_data.entities

import android.net.Uri

data class WordsEntity(
    val title: String = "",
    val fileName: String = "",
    val imagesFolder: String = "",
    val words: WordsFromFile? = null
)

data class WordsFromFile(
    val list: List<WordsFromFileEntity> = listOf()
)

data class WordsFromFileEntity(
    val word: String,
    val translate: String
)

data class ResultWords(
    val title: String,
    val imagePath: Uri,
    val words: WordsFromFile
)