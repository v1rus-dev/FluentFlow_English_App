package yegor.cheprasov.feature_admin_screens.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.tools.adminNormalTextStyle

@Composable
fun ExamplesPart(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Examples", style = adminNormalTextStyle)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewExamplesPart() {
    ExamplesPart()
}