package yegor.cheprasov.feature_grammar

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.navigation.findNavController
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_grammar.ui.GrammarScreen

class GrammarFragment : BaseComposeFragment() {

    override val composableFunction: @Composable () -> Unit
        get() = {
            val navController = LocalView.current.findNavController()
            GrammarScreen(navController)
        }
}