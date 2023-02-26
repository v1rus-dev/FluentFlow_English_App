package yegor.cheprasov.feature_admin_screens.screens.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.AdminAction
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.Group
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.HomeScreenState
import yegor.cheprasov.feature_admin_screens.screens.screens.home.state.TypeOfScreen
import yegor.cheprasov.feature_design.components.MainToolbar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(value: HomeScreenState, doOnAction: (AdminAction) -> Unit) {
    Scaffold(topBar = {
        MainToolbar(title = "Admin Console")
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                value.groups.forEachIndexed { groupIndex, group ->
                    stickyHeader {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Cyan)
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                        ) {
                            Text(text = group.type.name)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    group.list.forEachIndexed { index, adminAction ->
                        item {
                            Card(
                                shape = RoundedCornerShape(8.dp),
                                backgroundColor = adminAction.backgroundColor,
                                modifier = Modifier
                                    .height(56.dp)
                                    .clickable(role = Role.Button) {
                                        doOnAction(adminAction)
                                    }
                            ) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Text(text = adminAction.title)
                                }
                            }
                        }

                        if (index != group.list.lastIndex) {
                            item {
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                        if (index == group.list.lastIndex && groupIndex != value.groups.lastIndex) {
                            item {
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreenContent() {
    HomeScreenContent(
        value = HomeScreenState(
            arrayListOf<Group>().apply {
                add(
                    Group(
                        TypeOfScreen.Theme,
                        listOf(AdminAction.AddGrammar, AdminAction.AddExercises)
                    )
                )
                add(
                    Group(
                        TypeOfScreen.Words,
                        listOf(AdminAction.AddThemesOfWords, AdminAction.AddWordsToTheme)
                    )
                )
            }
        ),
        doOnAction = {}
    )
}