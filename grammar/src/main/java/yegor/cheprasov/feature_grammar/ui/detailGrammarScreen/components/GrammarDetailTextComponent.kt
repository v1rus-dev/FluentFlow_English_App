package yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import yegor.cheprasov.feature_grammar.viewEntities.GrammarDetailType

@Composable
fun GrammarDetailTextComponent(
    grammarDetailType: GrammarDetailType.TextViewEntity,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = grammarDetailType.text, fontSize = 16.sp, fontWeight = FontWeight.Normal, lineHeight = 24.sp)
    }
}

@Preview
@Composable
private fun PreviewGrammarDetailTextComponent() {
    GrammarDetailTextComponent(
        GrammarDetailType.TextViewEntity(
            text = "У глагола to be есть разные формы. Какую выбрать зависит от того, о чем речь. Если говоришь о себе, то используй am:"
        )
    )
}