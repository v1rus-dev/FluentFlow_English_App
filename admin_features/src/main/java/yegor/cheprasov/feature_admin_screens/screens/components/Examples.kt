package yegor.cheprasov.feature_admin_screens.screens.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yegor.cheprasov.feature_design.components.MiddleButton
import yegor.cheprasov.feature_design.tools.adminNormalTextStyle

@Composable
fun ExamplesPart(
    examples: List<String>,
    modifier: Modifier = Modifier,
    maxExamples: Int = 3,
    onAddExample: (String) -> Unit
) {
    val context = LocalContext.current
    val onShowAddNewElementState: MutableState<ShowAddElementType> = remember {
        mutableStateOf(ShowAddElementType.Close)
    }
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Examples", style = adminNormalTextStyle)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .padding(top = 8.dp)
        ) {
            examples.forEachIndexed { index, example ->
                MiddleButton(
                    text = example,
                    onClick = {},
                    isClickable = false,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                if (index != examples.lastIndex || examples.size < maxExamples) {
                    Spacer(modifier = Modifier.width(6.dp))
                }
            }
            if (onShowAddNewElementState.value is ShowAddElementType.Show) {
                GrammarExampleEditable { newExample ->
                    onAddExample(newExample)
                    onShowAddNewElementState.value = ShowAddElementType.Close
                }
                Spacer(modifier = Modifier.width(6.dp))
            }
            if (examples.size < maxExamples) {
                MiddleButton(
                    text = "Add",
                    onClick = {
                        onShowAddNewElementState.value = ShowAddElementType.Show
                    },
                    backgroundColor = Color.Magenta,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

sealed class ShowAddElementType {
    object Show : ShowAddElementType()
    object Close : ShowAddElementType()
}

@Composable
fun GrammarExampleEditable(
    onDone: (String) -> Unit
) {
    val requester = remember {
        FocusRequester()
    }
    val textField = remember {
        mutableStateOf("")
    }
    Card(shape = RoundedCornerShape(8.dp), backgroundColor = Color(0xFFBD6EEB)) {
        Row(modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp)) {
            BasicTextField(
                value = textField.value,
                cursorBrush = Brush.linearGradient(listOf(Color.White, Color.White)),
                modifier = Modifier
                    .focusRequester(requester)
                    .width(IntrinsicSize.Min),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onDone(textField.value)
                    }
                ),
                onValueChange = { text ->
                    textField.value = text
                }, decorationBox = {
                    if (textField.value.isEmpty()) {
                        Text(
                            text = "Example",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Italic
                            )
                        )
                    } else {
                        Text(
                            text = textField.value,
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1
                        )
                    }
                })
        }
    }

    LaunchedEffect(key1 = true) {
        requester.requestFocus()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewExamplesPart() {
    ExamplesPart(
        examples = listOf("123"),
        onAddExample = {}
    )
}