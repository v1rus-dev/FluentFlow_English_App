package yegor.cheprasov.feature_design.screens.acceptDialogScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.tools.ClickVariant

@Composable
fun AcceptDialogScreen(
    text: String,
    desc: String = "",
    onClick: (ClickVariant) -> Unit
) {

}

@Preview
@Composable
private fun PreviewAcceptDialogScreen() {
    AcceptDialogScreen(text = "Вы уверены что хотите завершить упражнение?") {

    }
}