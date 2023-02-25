package yegor.cheprasov.feature_grammar.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_data.usecases.GrammarUseCase
import yegor.cheprasov.feature_grammar.mappers.GrammarMapper
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity
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

    fun loadExercises(grammarElementViewEntity: GrammarElementViewEntity) = ioScope.launch {
        grammarUseCase.loadExercise(grammarElementViewEntity.exerciseFile)
            .collectLatest {
                Log.d("myTag", "exercise: ${it}")
            }
    }


}