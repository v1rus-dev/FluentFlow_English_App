package yegor.cheprasov.feature_design.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SmallButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    backgroundColor: Color = Color(0xFFBD6EEB),
    shape: Shape = RoundedCornerShape(8.dp)
) {
    Card(
        shape = shape,
        backgroundColor = backgroundColor,
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Row(modifier = Modifier.padding(vertical = 3.dp, horizontal = 10.dp)) {
            Text(text = text, style = textStyle)
        }
    }
}

@Composable
fun MiddleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    isClickable: Boolean = true,
    backgroundColor: Color = Color(0xFFBD6EEB),
    shape: Shape = RoundedCornerShape(8.dp)
) {
    Card(
        shape = shape,
        backgroundColor = backgroundColor,
        modifier = modifier.clickable(enabled = isClickable, role = Role.Button) {
            onClick()
        }
    ) {
        Row(modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp)) {
            Text(text = text, style = textStyle)
        }
    }
}

@Preview(name = "Small button")
@Composable
private fun PreviewSmallButton() {
    SmallButton(text = "This is", onClick = {})
}

@Preview(name = "Middle button")
@Composable
private fun PreviewMiddleButton() {
    MiddleButton(text = "This is", onClick = {})
}