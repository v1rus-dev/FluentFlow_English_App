package yegor.cheprasov.feature_words.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_data.usecases.WordsUseCase
import yegor.cheprasov.feature_words.mappers.WordsMapper
import yegor.cheprasov.feature_words.state.WordsState
import yegor.cheprasov.feature_words.ui.NewWordsAndPhrasesState
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val wordsUseCase: WordsUseCase,
    private val wordsMapper: WordsMapper
) : ViewModel() {

    private val coroutineException = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    private val ioScope =
        CoroutineScope(viewModelScope.coroutineContext + Dispatchers.IO + coroutineException)

    private val _state = MutableStateFlow(
        WordsState(
            newWordsAndPhrasesButtonState = NewWordsAndPhrasesState(
                learnedAmount = 0,
                allAmount = 0
            )
        )
    )

    val uiState = _state.asStateFlow()

    fun loadWords() = ioScope.launch {
        wordsUseCase.loadWords()
            .map {
                it.map { wordsMapper.map(it, 0) }
            }
            .map {
                _state.value.copy(list = it)
            }
            .onEach {
                Log.d("myTag", "state: $it")
            }
            .collect(_state::emit)
    }

}