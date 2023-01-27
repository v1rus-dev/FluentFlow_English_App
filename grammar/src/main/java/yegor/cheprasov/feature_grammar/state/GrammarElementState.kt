package yegor.cheprasov.feature_grammar.state

data class GrammarElementState(
    val id: Int,
    val title: String,
    val text: String,
    val examples: List<String>,
    val percentage: Int,
    val isFavorite: Boolean
)