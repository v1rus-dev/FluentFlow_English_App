package yegor.cheprasov.feature_data.entities

data class GrammarDetailEntity(
    val text: List<String>,
    val blocks: List<OneBlock>
)

data class OneBlock(
    val list: List<Block>
)

data class Block(
    val text: String,
    val translate: String
)
