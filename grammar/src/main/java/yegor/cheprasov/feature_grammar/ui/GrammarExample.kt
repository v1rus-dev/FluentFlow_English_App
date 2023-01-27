package yegor.cheprasov.feature_grammar.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GrammarExample(text: String) {
    Card(shape = RoundedCornerShape(8.dp), backgroundColor = Color(0xFFBD6EEB)) {
        Row(modifier = Modifier.padding(vertical = 3.dp, horizontal = 10.dp)) {
            Text(text = text, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Normal)
        }
    }
}

@Preview
@Composable
private fun PreviewGrammarExample() {
    GrammarExample(text = "This is")
}