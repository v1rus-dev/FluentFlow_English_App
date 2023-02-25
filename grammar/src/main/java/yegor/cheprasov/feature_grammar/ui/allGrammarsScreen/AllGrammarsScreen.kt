package yegor.cheprasov.feature_grammar.ui.allGrammarsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.LoadingScreen
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_grammar.state.GrammarUiState
import yegor.cheprasov.feature_grammar.ui.allGrammarsScreen.components.SuccessStateScreen
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity
import yegor.cheprasov.feature_grammar.viewModel.GrammarViewModel

@Composable
fun AllGrammarsScreen(
    grammarViewModel: GrammarViewModel,
    openDetailFragment: (String) -> Unit,
    onBack: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        grammarViewModel.load()
    }
    val state = grammarViewModel.uiState.collectAsState()
    GrammarScr(
        state = state.value, openDetailGrammar = {
            grammarViewModel.loadGrammarFile(it.fileName)
            openDetailFragment(it.title)
        }, onBack = onBack
    )
}

@Composable
private fun GrammarScr(
    state: GrammarUiState,
    openDetailGrammar: (GrammarElementViewEntity) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SecondToolbar("Грамматика", onBack = onBack)
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (state) {
                GrammarUiState.Loading -> LoadingScreen()
                is GrammarUiState.Success -> SuccessStateScreen(
                    state = state,
                    openDetailGrammar = openDetailGrammar
                )
            }
        }
    }
}

@Preview(name = "GrammarScreen")
@Composable
private fun PreviewGrammarScreen() {
    GrammarScr(
        state = GrammarUiState.Success(list = listOf()),
        openDetailGrammar = {},
        onBack = {}
    )
}