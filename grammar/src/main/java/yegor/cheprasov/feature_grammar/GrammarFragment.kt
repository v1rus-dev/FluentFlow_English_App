package yegor.cheprasov.feature_grammar

import androidx.compose.runtime.Composable
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_grammar.ui.GrammarScreen

class GrammarFragment : BaseComposeFragment() {

    override val composableFunction: @Composable () -> Unit
        get() = {
            GrammarScreen()
        }
}