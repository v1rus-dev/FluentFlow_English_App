package yegor.cheprasov.feature_grammar.viewEntities

data class GrammarElementViewEntity(
    val title: String,
    val subtitle: String,
    val examples: List<String>,
    val fileName: String,
    val exerciseFile: String,
    val percentage: Int,
    val isFavorite: Boolean
)