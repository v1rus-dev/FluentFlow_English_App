package yegor.cheprasov.feature_grammar.state

import yegor.cheprasov.feature_grammar.viewEntities.GrammarExerciseViewEntity

sealed class GrammarExerciseUiState {
    object Loading : GrammarExerciseUiState()

    data class Success(
        val percentage: Float,
        val successState: SuccessState,
        val isLast: Boolean,
        val grammarExerciseViewEntity: GrammarExerciseViewEntity
    ) : GrammarExerciseUiState()
}

sealed class SuccessState {

    object Success : SuccessState()

    class Error(
        val text: List<String>,
        val myAnswer: List<String>,
        val correctAnswer: List<String>
    ) : SuccessState()

    object None : SuccessState()

}
