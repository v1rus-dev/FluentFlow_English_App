package yegor.cheprasov.feature_grammar.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import yegor.cheprasov.feature_design.components.SecondToolbar

@Composable
fun GrammarScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            SecondToolbar("Грамматика") {
                navController.popBackStack()
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {

            }
        }
    }
}

@Preview(name = "GrammarScreen")
@Composable
private fun PreviewGrammarScreen() {
    GrammarScreen(rememberNavController())
}