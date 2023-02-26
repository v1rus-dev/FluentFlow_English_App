package yegor.cheprasov.feature_grammar.state

import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity

sealed class GrammarUiState {
    object Loading : GrammarUiState()

    class Success(
        val list: List<GrammarElementViewEntity>
    ) : GrammarUiState()
}
