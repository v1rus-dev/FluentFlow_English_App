package yegor.cheprasov.feature_design.tools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import yegor.cheprasov.feature_design.screens.acceptDialogScreen.AcceptDialogScreen

@OptIn(ExperimentalMaterialApi::class)
class AcceptDialog : BaseComposeDialog() {
    override val composableFunction: @Composable (ModalBottomSheetState) -> Unit
        get() = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AcceptDialogScreen(text = "") {

                }
            }
        }
}

enum class ClickVariant {
    OK, NO
}