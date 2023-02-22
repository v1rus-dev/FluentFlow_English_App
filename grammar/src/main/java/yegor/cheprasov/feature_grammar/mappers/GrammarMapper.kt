package yegor.cheprasov.feature_grammar.mappers

import yegor.cheprasov.feature_data.entities.GrammarDetailEntity
import yegor.cheprasov.feature_data.entities.GrammarEntity
import yegor.cheprasov.feature_grammar.state.GrammarUiStateDetail
import yegor.cheprasov.feature_grammar.viewEntities.GrammarDetailType
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity
import yegor.cheprasov.feature_grammar.viewEntities.OneBlockVE
import javax.inject.Inject
import kotlin.random.Random

class GrammarMapper @Inject constructor() {

    fun mapListToGrammarElementViewEntity(list: List<GrammarEntity>): List<GrammarElementViewEntity> =
        list.map(::mapToGrammarElementViewEntity)

    fun mapToGrammarElementViewEntity(grammarEntity: GrammarEntity): GrammarElementViewEntity =
        GrammarElementViewEntity(
            title = grammarEntity.title,
            subtitle = grammarEntity.subtitle,
            examples = grammarEntity.examples,
            fileName = grammarEntity.fileName,
            percentage = Random.nextInt(0, 100),
            isFavorite = false
        )

    fun mapGrammarDetail(grammarDetailEntity: GrammarDetailEntity): GrammarUiStateDetail.Success {
        val result = arrayListOf<GrammarDetailType>()
        for (i in 0..maxOf(grammarDetailEntity.text.size, grammarDetailEntity.blocks.size)) {
            val text = grammarDetailEntity.text.getOrNull(i)
            val block = grammarDetailEntity.blocks.getOrNull(i)
            if (text != null) {
                result.add(
                    GrammarDetailType.TextViewEntity(text)
                )
            }

            if (block != null) {
                result.add(GrammarDetailType.BlockViewEntity(
                    block.list.map {
                        OneBlockVE(it.text, it.translate)
                    }
                ))
            }
        }
        return GrammarUiStateDetail.Success(list = result)
    }

}