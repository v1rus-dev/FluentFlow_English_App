package yegor.cheprasov.feature_words.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import yegor.cheprasov.feature_design.components.Percentage
import yegor.cheprasov.feature_words.state.ResultWordsViewEntity
import yegor.cheprasov.feature_words.state.WordsFromFileViewEntity

@Composable
fun WordsThemeElement(wordsViewEntity: ResultWordsViewEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            backgroundColor = Color.White,
            modifier = Modifier.size(50.dp)
        ) {
            if (!wordsViewEntity.imagePath.path.isNullOrEmpty()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(wordsViewEntity.imagePath)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 13.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = wordsViewEntity.title)
                Row {
                    Text(text = "${wordsViewEntity.learnedWords} \\ ", color = Color.LightGray)
                    Text(text = wordsViewEntity.allWords.toString())
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Percentage(
                percentage = (wordsViewEntity.learnedWords / wordsViewEntity.allWords) * 100,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewWordsThemeElement() {
    WordsThemeElement(
        wordsViewEntity = ResultWordsViewEntity(
            title = "Книги",
            imagePath = Uri.parse("https://firebasestorage.googleapis.com/v0/b/fluentflow-english.appspot.com/o/words%2Fimages%2Fbooks%2Fmain.svg?alt=media&token=75265d19-ac48-40b8-aa88-8a704655693a"),
            allWords = 24,
            learnedWords = 10,
            words = WordsFromFileViewEntity(listOf())
        )
    )
}