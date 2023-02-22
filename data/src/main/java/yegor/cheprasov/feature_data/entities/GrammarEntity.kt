package yegor.cheprasov.feature_data.entities

data class GrammarEntity(
    val title: String = "",
    val subtitle: String = "",
    val fileName: String = "",
    val examples: List<String> = listOf()
)
