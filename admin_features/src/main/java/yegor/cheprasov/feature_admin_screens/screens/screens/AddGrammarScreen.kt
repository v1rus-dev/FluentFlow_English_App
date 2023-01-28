package yegor.cheprasov.feature_admin_screens.screens.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import yegor.cheprasov.feature_admin_screens.screens.components.CustomTextFieldAdmin
import yegor.cheprasov.feature_admin_screens.screens.components.ExamplesPart
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.GrammarViewModel
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.MainViewModel
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_design.tools.adminNormalTextStyle
import yegor.cheprasov.feature_design.tools.adminTitleTextStyle
import yegor.cheprasov.feature_design.tools.hintColor

object AddGrammarScreen : Screen {

    @Composable
    override fun Content() {
        val mainViewModel = getViewModel<MainViewModel>()
        val grammarViewModel = getViewModel<GrammarViewModel>()

        val state = grammarViewModel.uiState.collectAsState()

        val addState = remember<(String) -> Unit> { {
            grammarViewModel.addExample(it)
        } }

        AddGrammarScreen(
            state.value,
            onAddExample = addState
        )
    }

    @Composable
    fun AddGrammarScreen(
        state: List<String>,
        onAddExample: (String) -> Unit
    ) {
        val navigator = LocalNavigator.current
        val scrollState = rememberScrollState()
        val focusManager = LocalFocusManager.current

        var title by remember {
            mutableStateOf("")
        }
        var textOnCard by remember {
            mutableStateOf("")
        }

        Scaffold(topBar = {
            SecondToolbar(title = "Add grammar") {
                navigator?.pop()
            }
        }) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .padding(top = 8.dp)
                    .scrollable(scrollState, Orientation.Vertical)
            ) {
                CustomTextFieldAdmin(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    textStyle = adminTitleTextStyle,
                    placeHolder = {
                        Text(
                            text = "Title",
                            style = adminTitleTextStyle.copy(color = hintColor)
                        )
                    },
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    },
                    singleLine = true
                )
                CustomTextFieldAdmin(
                    value = textOnCard,
                    onValueChange = {
                        textOnCard = it
                    },
                    modifier = Modifier.padding(top = 4.dp),
                    textStyle = adminNormalTextStyle, placeHolder = {
                        Text(
                            text = "Description on card",
                            style = adminNormalTextStyle.copy(color = hintColor)
                        )
                    },
                    keyboardActions = KeyboardActions {
                        focusManager.clearFocus()
                    },
                    singleLine = true
                )
                ExamplesPart(
                    examples = listOf(),
                    modifier = Modifier.padding(top = 12.dp)
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAddGrammarScreen() {
    AddGrammarScreen.AddGrammarScreen(
        state = listOf(),
        onAddExample = {}
    )
}