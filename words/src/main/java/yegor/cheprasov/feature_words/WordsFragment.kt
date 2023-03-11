package yegor.cheprasov.feature_words

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yegor.cheprasov.feature_design.tools.BaseComposeFragment
import yegor.cheprasov.feature_words.state.WordsState
import yegor.cheprasov.feature_words.ui.NewWordsAndPhrasesState
import yegor.cheprasov.feature_words.ui.WordsScreen
import yegor.cheprasov.feature_words.viewmodel.WordsViewModel

@AndroidEntryPoint
class WordsFragment : BaseComposeFragment() {

    private val wordsViewModel: WordsViewModel by viewModels(ownerProducer = { requireActivity() })

    override val composableFunction: @Composable () -> Unit = {
        LaunchedEffect(key1 = Unit) {
            wordsViewModel.loadWords()
        }
        val state = wordsViewModel.uiState.collectAsState()
        WordsScreen(
            state = state.value
        )
    }

}