package yegor.cheprasov.feature_words.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.feature_design.components.MainToolbar
import yegor.cheprasov.feature_design.tools.background
import yegor.cheprasov.feature_words.state.WordsState
import yegor.cheprasov.feature_words.R

@Composable
fun WordsScreen(state: WordsState) {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(), backgroundColor = background, topBar = {
        MainToolbar(title = "Слова")
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NewWordsAnPhrasesButton(
                    state = state.newWordsAndPhrasesButtonState,
                    modifier = Modifier.padding(start = 16.dp, top = 22.dp)
                ) {
                    Toast.makeText(context, "111", Toast.LENGTH_SHORT).show()
                }
                Image(
                    painter = painterResource(id = R.drawable.hand_img),
                    contentDescription = null,
                    modifier = Modifier.graphicsLayer {
                        this.rotationZ = -30f
                    }
                )
            }
        }
    }
}

@Composable
@Preview
private fun PreviewWordsScreen() {
    WordsScreen(state = getWordsState())
}

private fun getWordsState(): WordsState =
    WordsState(0, NewWordsAndPhrasesState(6, 8))