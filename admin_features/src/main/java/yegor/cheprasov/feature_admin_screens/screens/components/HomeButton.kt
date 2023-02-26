package yegor.cheprasov.feature_admin_screens.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black
        ),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = ButtonDefaults.elevation()
    ) {
        Text(text = title)
    }
}

@Preview
@Composable
fun PreviewHomeButton() {
    HomeButton(
        title = "Add grammar",
        onClick = {}
    )
}