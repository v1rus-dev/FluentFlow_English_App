package yegor.cheprasov.feature_grammar.ui.fragments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_design.tools.parcelable
import yegor.cheprasov.feature_grammar.ui.exerciseScreen.ExerciseScreen
import yegor.cheprasov.feature_grammar.viewEntities.GrammarElementViewEntity
import yegor.cheprasov.feature_grammar.viewModel.GrammarExerciseViewModel

@AndroidEntryPoint
class GrammarExerciseFragment : BaseComposeFragment() {

    companion object {
        private const val GRAMMAR_ELEMENT = "grammarElement"
    }

    private val elementViewEntity: GrammarElementViewEntity by lazy {
        requireArguments().parcelable(GRAMMAR_ELEMENT) ?: throw NullPointerException()
    }

    private val viewModel: GrammarExerciseViewModel by viewModels({ this })

    override val composableFunction: @Composable () -> Unit
        get() = {
            LaunchedEffect(key1 = Unit) {
                viewModel.loadExercises(elementViewEntity)
            }
            ExerciseScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

}