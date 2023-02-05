package yegor.cheprasov.feature_admin_screens.screens.navigations

import cafe.adriel.voyager.core.screen.Screen
import yegor.cheprasov.feature_admin_screens.screens.screens.addGrammar.AddGrammarScreen as AddGramarSc
import yegor.cheprasov.feature_admin_screens.screens.screens.home.HomeScreen as HomeSc

sealed class ScreenNavigations(val screen: Screen) {
    object HomeScreen : ScreenNavigations(HomeSc)
    object AddGrammarScreen : ScreenNavigations(AddGramarSc)
}
