package yegor.cheprasov.feature_grammar.viewEntities

sealed class GrammarDetailType {
    data class TextViewEntity(val text: String) : GrammarDetailType()

    data class BlockViewEntity(
        val list: List<OneBlockVE>
    ) : GrammarDetailType()
}

data class OneBlockVE(
    val text: String,
    val translate: String
)

