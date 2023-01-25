package yegor.cheprasov.features_topics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.feature_design.components.MainToolbar
import yegor.cheprasov.feature_design.tools.background
import yegor.cheprasov.features_topics.fakedata.getFake
import yegor.cheprasov.features_topics.state.TopicsState

@Composable
fun TopicsScreen(state: TopicsState, onClick: (Int) -> Unit) {
    val listState = rememberLazyListState()
    Scaffold(
        backgroundColor = background,
        topBar = {
            MainToolbar(title = "Темы")
        }) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp)) {
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                contentPadding = PaddingValues(horizontal = 16.dp),
                state = listState
            ) {
                items(state.topics.size, key = {
                    state.topics[it].id
                }) { index ->
                    ThemItem(
                        title = state.topics[index].title,
                        description = state.topics[index].desc,
                        percentage = state.topics[index].percentages,
                        background = state.topics[index].background,
                        image = state.topics[index].image,
                        index = state.topics[index].id,
                        onClick = onClick
                    )
                    if (index != state.topics.lastIndex) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Preview(name = "TopicsScreen")
@Composable
private fun PreviewTopicsScreen() {
    TopicsScreen(getFake()) {}
}
