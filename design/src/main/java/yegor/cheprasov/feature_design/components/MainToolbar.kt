package yegor.cheprasov.feature_design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainToolbar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 16.dp, top = 20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
    }
}

@Preview(name = "MainToolbar")
@Composable
private fun PreviewMainToolbar() {
    MainToolbar(title = "Темы")
}
