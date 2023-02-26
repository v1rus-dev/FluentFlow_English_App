package yegor.cheprasov.feature_admin_screens.screens.screens.home.state

import androidx.compose.ui.graphics.Color

data class HomeScreenState(
    val groups: List<Group>
)

data class Group(
    val type: TypeOfScreen,
    val list: List<AdminAction>
)

sealed class AdminAction(
    val title: String,
    val backgroundColor: Color
) {

    object AddGrammar: AdminAction("Add grammar", Color.LightGray)

    object AddExercises : AdminAction("Add exercises", Color.LightGray)

    object AddThemesOfWords : AdminAction("Add themes of words", Color.LightGray)

    object AddWordsToTheme : AdminAction("Add words to theme", Color.LightGray)

}

sealed class TypeOfScreen(val name: String) {
    object Theme : TypeOfScreen("Themes")
    object Words : TypeOfScreen("Words")
}
