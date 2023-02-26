package yegor.cheprasov.feature_grammar.ui.exerciseScreen.components

import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment

@Composable
fun TextPart(text: List<String>, modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        mainAxisSpacing = 35.dp,
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        text.forEach {
            Text(it, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun PreviewTextPart() {
    TextPart(text = listOf("The apartment", "big"))
}