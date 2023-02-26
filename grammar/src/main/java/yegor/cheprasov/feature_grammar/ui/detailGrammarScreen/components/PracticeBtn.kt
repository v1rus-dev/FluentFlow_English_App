package yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.AppButton

@Composable
fun PracticeBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    AppButton(text = "Практика", modifier = modifier) {
        onClick.invoke()
    }
}

@Preview
@Composable
private fun PreviewPracticeBtn() {
    PracticeBtn {

    }
}