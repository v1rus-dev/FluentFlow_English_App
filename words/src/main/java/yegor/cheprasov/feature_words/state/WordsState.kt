package yegor.cheprasov.feature_words.state

import android.net.Uri
import yegor.cheprasov.feature_words.ui.NewWordsAndPhrasesState

data class WordsState(
    val newWordsAndPhrasesButtonState: NewWordsAndPhrasesState,
    val list: List<ResultWordsViewEntity> = listOf()
)

data class ResultWordsViewEntity(
    val title: String,
    val imagePath: Uri,
    val allWords: Int,
    val learnedWords: Int,
    val words: WordsFromFileViewEntity
)

data class WordsFromFileViewEntity(
    val list: List<WordsViewEntity> = listOf()
)

data class WordsViewEntity(
    val word: String,
    val translate: String
)