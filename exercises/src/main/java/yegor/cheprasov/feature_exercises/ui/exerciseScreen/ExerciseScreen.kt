package yegor.cheprasov.feature_exercises.ui.exerciseScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.feature_design.components.SecondToolbar
import yegor.cheprasov.feature_design.tools.background

@Composable
fun ExerciseScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SecondToolbar(title = "Переведите предложение") {
                onBack()
            }
        },
        backgroundColor = background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}

@Preview
@Composable
private fun PreviewExerciseScreen() {
    ExerciseScreen(
        onBack = {}
    )
}