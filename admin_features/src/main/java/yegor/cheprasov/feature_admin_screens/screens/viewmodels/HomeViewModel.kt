package yegor.cheprasov.feature_admin_screens.screens.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.AdminAction
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.Group
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.HomeScreenState
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.TypeOfScreen
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    private val mutableState = MutableStateFlow(getUiState())

    val uiState: StateFlow<HomeScreenState> = mutableState

    private fun getUiState(): HomeScreenState = HomeScreenState(
        groups = arrayListOf<Group>().apply {
            add(
                Group(
                    TypeOfScreen.Theme,
                    listOf(AdminAction.AddGrammar, AdminAction.AddExercises)
                )
            )
            add(
                Group(
                    TypeOfScreen.Words,
                    listOf(AdminAction.AddThemesOfWords, AdminAction.AddWordsToTheme)
                )
            )
        }
    )

}