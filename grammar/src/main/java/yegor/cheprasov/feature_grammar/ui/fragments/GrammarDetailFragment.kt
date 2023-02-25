package yegor.cheprasov.feature_grammar.ui.fragments

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_grammar.R
import yegor.cheprasov.feature_grammar.ui.detailGrammarScreen.DetailGrammarScreen
import yegor.cheprasov.feature_grammar.viewModel.GrammarViewModel

@AndroidEntryPoint
class GrammarDetailFragment : BaseComposeFragment() {

    companion object {
        fun getBundle(
            title: String
        ): Bundle = Bundle().apply {
            putString(TITLE, title)
        }

        private const val TITLE = "TITLE"
    }

    private val viewModel: GrammarViewModel by hiltNavGraphViewModels(R.id.grammar_nav_graph)

    override val composableFunction: @Composable () -> Unit
        get() = {
            val onBack: () -> Unit = remember {
                {
                    navController.popBackStack()
                }
            }
            DetailGrammarScreen(
                title = requireArguments().getString(TITLE, ""),
                grammarViewModel = viewModel,
                onBack = onBack
            )
        }
}