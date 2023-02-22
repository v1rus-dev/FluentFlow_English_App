package yegor.cheprasov.feature_grammar.state

import yegor.cheprasov.feature_grammar.viewEntities.GrammarDetailType

sealed class GrammarUiStateDetail {

    object Loading : GrammarUiStateDetail()

    class Success(val list: List<GrammarDetailType>) : GrammarUiStateDetail()

}