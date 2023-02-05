package yegor.cheprasov.feature_admin_screens.screens.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.GrammarViewModel
import yegor.cheprasov.feature_admin_screens.screens.viewmodels.MainViewModel

const val MAX_EXAMPLES = 3

object AddGrammarScreen : Screen {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content() {
        val coroutineScope = rememberCoroutineScope()
        val mainViewModel = getViewModel<MainViewModel>()
        val grammarViewModel = getViewModel<GrammarViewModel>()
        val pagerState = rememberPagerState()

        val state = grammarViewModel.uiState.collectAsState()

        val addState = remember<(String) -> Unit> {
            {
                grammarViewModel.addExample(it)
            }
        }

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = 2,
            state = pagerState
        ) { page ->
            if (page == 0) {
                AddGrammarFirstScreen(
                    state = state.value,
                    onAddExample = addState,
                    goToSecondScreen = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(1)
                        }
                    })
            }
            if (page == 1) {
                AddGrammarSecondScreen()
            }
        }
    }
}