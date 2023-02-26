package yegor.cheprasov.features_topics

import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.GlobalDestinations
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_design.SharedViewModel
import yegor.cheprasov.features_topics.ui.TopicsScreen
import yegor.cheprasov.features_topics.viewmodel.TopicsViewModel

@AndroidEntryPoint
class TopicsFragment : BaseComposeFragment() {

    private val topicsViewModel: TopicsViewModel by viewModels(ownerProducer = { requireActivity() })
    private val sharedViewModel: SharedViewModel by viewModels(ownerProducer = { requireActivity() })

    override val onBackPressedCallback: OnBackPressedCallback
        get() = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                sharedViewModel.navigateTo(GlobalDestinations.None)
            }
        }

    override val composableFunction: @Composable () -> Unit
        get() = {
            val state = topicsViewModel.state.collectAsState()
            TopicsScreen(state.value) {
                sharedViewModel.navigateTo(it)
            }
        }

}