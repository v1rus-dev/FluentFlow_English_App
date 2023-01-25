package yegor.cheprasov.feature_words.state

import yegor.cheprasov.feature_words.ui.NewWordsAndPhrasesState

data class WordsState(
    val id: Int = 0,
    val newWordsAndPhrasesButtonState: NewWordsAndPhrasesState
)