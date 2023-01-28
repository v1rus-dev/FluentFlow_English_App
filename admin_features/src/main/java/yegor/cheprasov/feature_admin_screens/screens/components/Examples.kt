package yegor.cheprasov.feature_admin_screens.screens.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yegor.cheprasov.feature_design.components.GrammarExample
import yegor.cheprasov.feature_design.components.SmallButton
import yegor.cheprasov.feature_design.tools.adminNormalTextStyle

@Composable
fun ExamplesPart(
    examples: List<String>,
    modifier: Modifier = Modifier,
    maxExamples: Int = 3,
    onAddExample: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Examples", style = adminNormalTextStyle)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .padding(top = 8.dp)
        ) {
            examples.forEachIndexed { index, s ->
                GrammarExample(text = s)
            }
            if (examples.size < maxExamples) {
                SmallButton(
                    text = "Add",
                    onClick = {

                    }, textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewExamplesPart() {
    ExamplesPart(
        examples = listOf(),
        onAddExample = {}
    )
}