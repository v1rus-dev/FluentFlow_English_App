package yegor.cheprasov.feature_grammar.ui.allGrammarsScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.feature_design.components.GrammarMenuCard
import yegor.cheprasov.feature_grammar.state.GrammarUiState
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity

@Composable
fun SuccessStateScreen(
    state: GrammarUiState.Success,
    openDetailGrammar: (GrammarElementViewEntity) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(state.list.size) { index ->
            val element = state.list[index]
            GrammarMenuCard(
                title = element.title,
                subtitle = element.subtitle,
                examples = element.examples,
                percentage = element.percentage,
                isFavorite = element.isFavorite,
                modifier = Modifier.clickable {
                    openDetailGrammar(element)
                }
            )
            if (index != state.list.lastIndex) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSuccessStateScreen() {
    SuccessStateScreen(
        state = GrammarUiState.Success(listOf()),
        openDetailGrammar = {}
    )
}