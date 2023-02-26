package yegor.cheprasov.feature_grammar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_data.usecases.GrammarUseCase
import yegor.cheprasov.feature_grammar.mappers.GrammarMapper
import yegor.cheprasov.feature_grammar.state.GrammarExerciseUiState
import yegor.cheprasov.feature_grammar.state.SuccessState
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity
import yegor.cheprasov.feature_grammar.viewEntities.GrammarExerciseViewEntity
import javax.inject.Inject

@HiltViewModel
class GrammarExerciseViewModel @Inject constructor(
    private val grammarUseCase: GrammarUseCase,
    private val grammarMapper: GrammarMapper
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    private val ioScope =
        CoroutineScope(viewModelScope.coroutineContext + Dispatchers.IO + exceptionHandler)

    private var currentIndex = 0
    private var allCountOfExercises: Int = 0
    private val grammarExerciseViewEntities = arrayListOf<GrammarExerciseViewEntity>()

    private val mutableFinish = MutableStateFlow(false)
    val finish: StateFlow<Boolean> = mutableFinish

    private val mutableUiState =
        MutableStateFlow<GrammarExerciseUiState>(GrammarExerciseUiState.Loading)
    val uiState: StateFlow<GrammarExerciseUiState> = mutableUiState

    fun loadExercises(grammarElementViewEntity: GrammarElementViewEntity) = ioScope.launch {
        grammarUseCase.loadExercise(grammarElementViewEntity.exerciseFile)
            .map(grammarMapper::mapGrammarExercise)
            .onEach {
                grammarExerciseViewEntities.addAll(it)
                allCountOfExercises = it.size
            }
            .collectLatest {
                mutableUiState.emit(
                    GrammarExerciseUiState.Success(
                        percentage = 0f,
                        successState = SuccessState.None,
                        isLast = false,
                        grammarExerciseViewEntity = it.first()
                    )
                )
            }
    }

    fun checkAnswer(vararg answer: String) = ioScope.launch {
        if (uiState.value is GrammarExerciseUiState.Success) {
            val isSuccess = answer.toList() == grammarExerciseViewEntities[currentIndex].correctWords
            mutableUiState.emit(
                (uiState.value as GrammarExerciseUiState.Success).copy(
                    successState = if (isSuccess) {
                        SuccessState.Success
                    } else {
                        SuccessState.Error(
                            text = grammarExerciseViewEntities[currentIndex].text,
                            myAnswer = answer.toList(),
                            correctAnswer = grammarExerciseViewEntities[currentIndex].correctWords
                        )
                    }
                )
            )
            if (isSuccess) {
                delay(2000)
                continueExercise()
            }
        }
    }

    fun continueExercise() = ioScope.launch {
        if (currentIndex != allCountOfExercises) {
            currentIndex++
            mutableUiState.emit(
                GrammarExerciseUiState.Success(
                    percentage = (currentIndex.toFloat() / allCountOfExercises),
                    successState = SuccessState.None,
                    isLast = currentIndex == grammarExerciseViewEntities.lastIndex,
                    grammarExerciseViewEntity = grammarExerciseViewEntities[currentIndex]
                )
            )
        } else {
            mutableFinish.emit(true)
        }
    }
}