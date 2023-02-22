package yegor.cheprasov.feature_grammar.ui.fragments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_grammar.R
import yegor.cheprasov.feature_grammar.ui.allGrammarsScreen.AllGrammarsScreen
import yegor.cheprasov.feature_grammar.viewModel.GrammarViewModel

@AndroidEntryPoint
class GrammarFragment : BaseComposeFragment() {

    private val navController by lazy {
        findNavController()
    }

    private val viewModel: GrammarViewModel by hiltNavGraphViewModels(R.id.grammar_nav_graph)

    override val composableFunction: @Composable () -> Unit
        get() = {
            val openDetailFragment: (String) -> Unit = remember {
                { title ->
                    val bundle = GrammarDetailFragment.getBundle(title)
                    navController.navigate(R.id.to_detail_grammar_fragment, bundle)
                }
            }
            val onBack: () -> Unit = remember {
                {
                    navController.popBackStack()
                }
            }
            AllGrammarsScreen(
                grammarViewModel = viewModel,
                openDetailFragment = openDetailFragment,
                onBack = onBack
            )
        }
}