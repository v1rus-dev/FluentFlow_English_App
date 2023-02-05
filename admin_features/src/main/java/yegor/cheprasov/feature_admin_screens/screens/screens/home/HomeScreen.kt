package yegor.cheprasov.feature_admin_screens.screens.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.AdminAction
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.HomeViewModel
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.MainViewModel

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val mainViewModel = getViewModel<MainViewModel>()
        val homeViewModel = getViewModel<HomeViewModel>()
        val navigator = LocalNavigator.current

        val state = homeViewModel.uiState.collectAsState()

        HomeScreenContent(state.value, doOnAction = { adminAction ->
            when(adminAction) {
                AdminAction.AddExercises -> Unit
                AdminAction.AddGrammar -> Unit
                AdminAction.AddThemesOfWords -> Unit
                AdminAction.AddWordsToTheme -> Unit
            }
        })
    }
}