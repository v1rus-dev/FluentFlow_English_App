package yegor.cheprasov.features_topics.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import yegor.cheprasov.feature_data.GlobalDestinations
import yegor.cheprasov.features_topics.Topic
import yegor.cheprasov.features_topics.state.TopicsState
import javax.inject.Inject
import yegor.cheprasov.features_topics.R

@HiltViewModel
class TopicsViewModel @Inject constructor() : ViewModel() {

    private val mutableTopicState = MutableStateFlow(getTopicState())
    val state: StateFlow<TopicsState> = mutableTopicState

    private fun getTopicState(): TopicsState =
        TopicsState(
            topics = listOf(
                Topic(
                    "Грамматика",
                    "Изучайте правила грамматики",
                    66,
                    0,
                    GlobalDestinations.Grammar,
                    background = R.drawable.first_them_bg,
                    image = R.drawable.grammar_img
                ),
                Topic(
                    title = "Упражнения",
                    desc = "Делайте упражнения",
                    percentages = 46,
                    id = 1,
                    destination = GlobalDestinations.Exercise,
                    background = R.drawable.first_them_bg,
                    image = R.drawable.exercise_img
                ),
                Topic(
                    title = "Лексика",
                    desc = "Учите слова",
                    percentages = 20,
                    id = 2,
                    destination = GlobalDestinations.Words,
                    background = R.drawable.first_them_bg,
                    image = R.drawable.vocabulary_img
                )
            )
        )

}