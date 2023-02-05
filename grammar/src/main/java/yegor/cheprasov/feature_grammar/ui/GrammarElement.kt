package yegor.cheprasov.feature_grammar.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.GrammarMenuCard
import yegor.cheprasov.feature_grammar.state.GrammarElementState


@Composable
fun GrammarElement(grammarElementState: GrammarElementState) {
    with(grammarElementState) {
        GrammarMenuCard(
            title = title,
            text = text,
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

private fun getGrammarElementState() = GrammarElementState(
    id = 0,
    title = "Present Simple",
    text = "Am, is, are",
    examples = listOf("This is", "It is"),
    percentage = 35,
    isFavorite = false
)