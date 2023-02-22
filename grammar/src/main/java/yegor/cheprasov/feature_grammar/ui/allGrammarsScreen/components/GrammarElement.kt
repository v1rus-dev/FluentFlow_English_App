package yegor.cheprasov.feature_grammar.ui.allGrammarsScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.GrammarMenuCard
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity


@Composable
fun GrammarElement(grammarElementState: GrammarElementViewEntity) {
    with(grammarElementState) {
        GrammarMenuCard(
            title = title,
            subtitle = subtitle,
            examples = examples,
            percentage = percentage,
            isFavorite = isFavorite
        )
    }
}

@Composable
@Preview
private fun PreviewGrammarElement() {
    GrammarElement(getGrammarElementState())
}

private fun getGrammarElementState() = GrammarElementViewEntity(
    title = "Present Simple",
    subtitle = "Am, is, are",
    examples = listOf("This is", "It is"),
    percentage = 35,
    fileName = "",
    isFavorite = false
)