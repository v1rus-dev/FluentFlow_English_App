package yegor.cheprasov.feature_grammar.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_data.usecases.GrammarUseCase
import yegor.cheprasov.feature_grammar.mappers.GrammarMapper
import yegor.cheprasov.feature_grammar.state.GrammarUiState
import yegor.cheprasov.feature_grammar.state.GrammarUiStateDetail
import javax.inject.Inject

@HiltViewModel
class GrammarViewModel @Inject constructor(
    private val grammarUseCase: GrammarUseCase,
    private val grammarMapper: GrammarMapper
): ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    private val ioScope = CoroutineScope(viewModelScope.coroutineContext + Dispatchers.IO + exceptionHandler)

    private val mutableUiState = MutableStateFlow<GrammarUiState>(GrammarUiState.Loading)
    val uiState: StateFlow<GrammarUiState> = mutableUiState

    private val mutableUiStateDetail = MutableStateFlow<GrammarUiStateDetail>(GrammarUiStateDetail.Loading)
    val detailUiState: StateFlow<GrammarUiStateDetail> = mutableUiStateDetail

    fun load() = ioScope.launch {
        grammarUseCase.loadGrammars()
            .map(grammarMapper::mapListToGrammarElementViewEntity)
            .map { GrammarUiState.Success(it) }
            .collectLatest(mutableUiState::emit)
    }

    fun loadGrammarFile(fileName: String) = ioScope.launch {
        mutableUiStateDetail.emit(GrammarUiStateDetail.Loading)
        grammarUseCase.loadGrammarFile(fileName)
            .map(grammarMapper::mapGrammarDetail)
            .collectLatest(mutableUiStateDetail::emit)
    }

}