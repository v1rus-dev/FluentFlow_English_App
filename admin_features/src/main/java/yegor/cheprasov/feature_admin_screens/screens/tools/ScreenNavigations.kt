package yegor.cheprasov.feature_admin_screens.screens.tools

import cafe.adriel.voyager.core.screen.Screen
import yegor.cheprasov.feature_admin_screens.screens.screens.AddGrammarScreen as AddGramarSc
import yegor.cheprasov.feature_admin_screens.screens.screens.HomeScreen as HomeSc

sealed class ScreenNavigations(val screen: Screen) {
    object HomeScreen : ScreenNavigations(HomeSc)
    object AddGrammarScreen : ScreenNavigations(AddGramarSc)
}
