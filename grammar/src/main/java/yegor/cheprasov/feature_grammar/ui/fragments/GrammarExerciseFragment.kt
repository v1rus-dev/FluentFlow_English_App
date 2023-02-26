package yegor.cheprasov.feature_grammar.ui.fragments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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

            val finish = viewModel.finish.collectAsState()

            LaunchedEffect(key1 = finish) {
                if (finish.value) {
                    navController.popBackStack()
                }
            }

            val state = viewModel.uiState.collectAsState()
            ExerciseScreen(
                state = state.value,
                onCheck = {
                    viewModel.checkAnswer(it)
                },
                onContinue = { isLast ->
                    if (isLast) {
                        navController.popBackStack()
                    } else {
                        viewModel.continueExercise()
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

}