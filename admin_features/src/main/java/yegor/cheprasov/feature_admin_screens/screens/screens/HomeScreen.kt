package yegor.cheprasov.feature_admin_screens.screens.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import yegor.cheprasov.feature_admin_screens.screens.components.HomeButton
import yegor.cheprasov.feature_admin_screens.screens.tools.ScreenNavigations
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.MainViewModel
import yegor.cheprasov.feature_design.components.MainToolbar

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val mainViewModel = getViewModel<MainViewModel>()

        HomeScreen()
    }

    @Composable
    fun HomeScreen() {
        val context = LocalContext.current
        val navigator = LocalNavigator.current

        Scaffold(topBar = {
            MainToolbar(title = "Admin Console")
        }) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
            ) {
                Text(text = "Add new grammar")
                HomeButton(title = "Add Grammar", modifier = Modifier.width(150.dp)) {
                    navigator?.push(ScreenNavigations.AddGrammarScreen.screen)
                }
            }
        }
    }

}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen.HomeScreen()
}