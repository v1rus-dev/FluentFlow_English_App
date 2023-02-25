package yegor.cheprasov.feature_grammar.ui.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_grammar.ui.exerciseScreen.ExerciseScreen
import yegor.cheprasov.feature_grammar.viewModel.GrammarExerciseViewModel

class GrammarExerciseFragment : BaseComposeFragment() {

    private val viewModel: GrammarExerciseViewModel by viewModels({ this })

    override val composableFunction: @Composable () -> Unit
        get() = {
            ExerciseScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

}