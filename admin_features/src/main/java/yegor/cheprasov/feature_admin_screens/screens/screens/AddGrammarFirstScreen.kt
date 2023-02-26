package yegor.cheprasov.feature_admin_screens.screens.screens

import android.util.Log
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import yegor.cheprasov.feature_admin_screens.screens.components.CustomTextFieldAdmin
import yegor.cheprasov.feature_admin_screens.screens.components.ExamplesPart
import yegor.cheprasov.feature_design.components.GrammarMenuCard
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_design.tools.adminNormalTextStyle
import yegor.cheprasov.feature_design.tools.adminTitleTextStyle
import yegor.cheprasov.feature_design.tools.hintColor
import kotlin.random.Random

@Composable
fun AddGrammarFirstScreen(
    state: List<String>,
    onAddExample: (String) -> Unit,
    goToSecondScreen: () -> Unit
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
    val examples = remember {
        mutableStateListOf<String>()
    }
    val randomPercentage = remember {
        Random.nextInt(0, 100)
    }

    Scaffold(
        topBar = {
            SecondToolbar(title = "Add grammar") {
                navigator?.pop()
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Gray,
                        disabledContentColor = Color.LightGray
                    ),
                    enabled = title.isNotEmpty() && textOnCard.isNotEmpty() && examples.isNotEmpty(),
                    onClick = {
                        goToSecondScreen()
                    }) {
                    Text(text = "Continue")
                }
            }
        }
    ) {
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
                textStyle = adminNormalTextStyle.copy(color = Color.Gray),
                placeHolder = {
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
                examples = examples,
                modifier = Modifier.padding(top = 12.dp)
            ) { newExample ->
                examples.add(newExample)
                Log.d("myTag", "currentExmaples: ${examples}")
            }
            GrammarMenuCard(
                title = title.ifEmpty { "Title example" },
                subtitle = textOnCard.ifEmpty { "Description on card example" },
                examples = if (examples.isEmpty()) {
                    listOf("Example", "Ex", "Example")
                } else {
                    examples
                },
                percentage = randomPercentage,
                isFavorite = false,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAddGrammarScreen() {
    AddGrammarFirstScreen(
        state = listOf(),
        onAddExample = {},
        goToSecondScreen = {}
    )
}