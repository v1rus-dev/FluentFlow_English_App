package yegor.cheprasov.feature_grammar.ui.detailGrammarScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.feature_design.components.LoadingScreen
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_grammar.state.GrammarUiStateDetail
import yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.components.GrammarDetailBlockComponent
import yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.components.GrammarDetailTextComponent
import yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.components.PracticeBtn
import yegor.cheprasov.feature_grammar.viewEntities.GrammarDetailType
import yegor.cheprasov.feature_grammar.viewEntities.OneBlockVE
import yegor.cheprasov.feature_grammar.viewModel.GrammarViewModel

@Composable
fun DetailGrammarScreen(
    title: String,
    grammarViewModel: GrammarViewModel,
    onBack: () -> Unit
) {
    val state: State<GrammarUiStateDetail> = grammarViewModel.detailUiState.collectAsState()
    val onPractice: () -> Unit = remember { {
        grammarViewModel.loadExercises()
    }}
    DetailGrammarSc(
        title = title,
        state = state.value,
        onPractice = onPractice,
        onBack = onBack
    )
}

@Composable
private fun DetailGrammarSc(
    title: String,
    state: GrammarUiStateDetail,
    onPractice: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SecondToolbar(title, onBack = onBack)
        },
        backgroundColor = Color(0xFFFAF9F9)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (state) {
                GrammarUiStateDetail.Loading -> {
                    LoadingScreen()
                }

                is GrammarUiStateDetail.Success -> {
                    SuccessScreen(state.list, onPractice)
                }
            }
        }
    }
}

@Composable
private fun SuccessScreen(list: List<GrammarDetailType>, onPractice: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        SuccessLazyColumnPart(list = list)
        PracticeBtn(modifier = Modifier.padding(16.dp)) {
            onPractice.invoke()
        }
    }
}

@Composable
private fun SuccessLazyColumnPart(list: List<GrammarDetailType>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp),
        contentPadding = PaddingValues(
            top = 8.dp,
            bottom = 84.dp
        )
    ) {
        itemsIndexed(list) { index, item ->
            when (val type = item) {
                is GrammarDetailType.BlockViewEntity -> GrammarDetailBlockComponent(
                    grammarDetailType = type
                )

                is GrammarDetailType.TextViewEntity -> GrammarDetailTextComponent(
                    grammarDetailType = type
                )
            }
            if (index != list.lastIndex) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDetailGrammarScreenLoading() {
    DetailGrammarSc(
        title = "Am, is, are",
        state = GrammarUiStateDetail.Loading,
        onPractice = {},
        onBack = {}
    )
}

@Preview
@Composable
private fun PreviewDetailGrammarScreenSuccess() {
    DetailGrammarSc(
        title = "Am, is, are",
        state = GrammarUiStateDetail.Success(
            listOf(
                GrammarDetailType.TextViewEntity(
                    text = "У глагола to be есть разные формы. Какую выбрать зависит от того, о чем речь. Если говоришь о себе, то используй am:"
                ),
                GrammarDetailType.BlockViewEntity(
                    listOf(
                        OneBlockVE(
                            text = "Hi! I am Max.",
                            translate = "Привет! Я Макс."
                        )
                    )
                ),
                GrammarDetailType.TextViewEntity(
                    text = "В случаях, когда речь о множественном числе, то ставь are:"
                ),
                GrammarDetailType.BlockViewEntity(
                    listOf(
                        OneBlockVE(
                            text = "My suitcases are black.",
                            translate = "Мои чемоданы черные."
                        ),
                        OneBlockVE(
                            text = "They are big.",
                            translate = "Они большие."
                        )
                    )
                )
            )
        ),
        onPractice = {},
        onBack = {}
    )
}