package yegor.cheprasov.feature_grammar.ui.detailGrammarScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_grammar.viewModel.GrammarViewModel

@Composable
fun DetailGrammarScreen(
    title: String,
    grammarViewModel: GrammarViewModel,
    onBack: () -> Unit
) {
    val state = grammarViewModel.detailUiState.collectAsState()
    DetailGrammarSc(
        title = title,
        onBack = onBack
    )
}

@Composable
private fun DetailGrammarSc(
    title: String,
    onBack: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        SecondToolbar(title, onBack = onBack)
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}

@Preview
@Composable
private fun PreviewDetailGrammarScreen() {
    DetailGrammarSc(
        title = "Am, is, are",
        onBack = {}
    )
}