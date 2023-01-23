package yegor.cheprasov.features_topics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_design.tools.SharedViewModel
import yegor.cheprasov.features_topics.ui.TopicsScreen
import yegor.cheprasov.features_topics.viewmodel.TopicsViewModel

@AndroidEntryPoint
class TopicsFragment : BaseComposeFragment() {

    private val topicsViewModel: TopicsViewModel by viewModels(ownerProducer = { requireActivity() })
    private val sharedViewModel: SharedViewModel by viewModels(ownerProducer = { requireActivity() })

    override val composableFunction: @Composable () -> Unit
        get() = {
            val state = topicsViewModel.state.collectAsState()
            TopicsScreen(state.value) {

            }
        }

}