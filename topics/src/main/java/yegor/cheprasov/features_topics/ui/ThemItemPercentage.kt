package yegor.cheprasov.features_topics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val PERCENTAGE_COLOR_FIRST = Color(0xFF5BD3C7)
val PERCENTAGE_COLOR_SECOND = Color(0xFFE5E5E5)

@Composable
fun ThemItemPercentage(
    percentage: Int,
    modifier: Modifier = Modifier
) {
    val percentageValue by remember {
        mutableStateOf((percentage * 0.01).toFloat())
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(7.dp),
        backgroundColor = PERCENTAGE_COLOR_SECOND,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(percentageValue)
                    .height(7.dp),
                backgroundColor = PERCENTAGE_COLOR_FIRST,
                elevation = 0.dp,
                shape = RoundedCornerShape(5.dp)
            ) {

            }
        }
    }
}

@Preview(name = "ThemItemPercentage")
@Composable
private fun PreviewThemItemPercentage() {
    ThemItemPercentage(76)
}