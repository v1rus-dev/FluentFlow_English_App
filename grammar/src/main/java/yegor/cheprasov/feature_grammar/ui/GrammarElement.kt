package yegor.cheprasov.feature_grammar.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yegor.cheprasov.feature_design.components.FavoriteButton
import yegor.cheprasov.feature_design.components.Percentage
import yegor.cheprasov.feature_grammar.state.GrammarElementState

private val titleTextColor = Color(0xFFC5C6C7)

@Composable
fun GrammarElement(grammarElementState: GrammarElementState) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = grammarElementState.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = titleTextColor
                )
                Text(
                    text = grammarElementState.text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Row(modifier = Modifier.padding(top = 6.dp)) {
                    grammarElementState.examples.forEachIndexed { index, example ->
                        GrammarExample(text = example)
                        if (index != grammarElementState.examples.lastIndex) {
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                FavoriteButton(
                    isFavorite = grammarElementState.isFavorite,
                    modifier = Modifier.size(24.dp)
                ) {
                    Toast.makeText(context, "Tap on favorite", Toast.LENGTH_SHORT).show()
                }
                Percentage(
                    percentage = grammarElementState.percentage,
                    modifier = Modifier
                        .width(80.dp)
                        .padding(top = 32.dp)
                )
            }
        }
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