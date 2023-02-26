package yegor.cheprasov.feature_exercises.ui

import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.GlobalDestinations
import yegor.cheprasov.feature_design.SharedViewModel
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_exercises.ui.exerciseScreen.ExerciseScreen

@AndroidEntryPoint
class ExerciseFragment : BaseComposeFragment() {

    private val sharedViewModel: SharedViewModel by viewModels({ requireActivity() })

    override val onBackPressedCallback: OnBackPressedCallback
        get() = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                sharedViewModel.navigateTo(GlobalDestinations.None)
            }
        }
    override val composableFunction: @Composable () -> Unit
        get() = {
            val onBack: () -> Unit = remember {
                {
                    sharedViewModel.navigateTo(GlobalDestinations.None)
                }
            }
            ExerciseScreen(
                onBack = onBack
            )
        }
}