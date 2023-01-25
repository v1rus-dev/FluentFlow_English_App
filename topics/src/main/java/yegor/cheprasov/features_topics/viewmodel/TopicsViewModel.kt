package yegor.cheprasov.features_topics.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import yegor.cheprasov.features_topics.Topic
import yegor.cheprasov.features_topics.state.TopicsState
import javax.inject.Inject
import yegor.cheprasov.features_topics.R

@HiltViewModel
class TopicsViewModel @Inject constructor() : ViewModel() {

    private val mutableTopicState = MutableStateFlow(getTopicState())
    val state: StateFlow<TopicsState> = mutableTopicState

    private fun getTopicState(): TopicsState {
        val x = arrayListOf<Topic>()
        for (i in 0..100) {
            if (i % 2 == 0) {
                x.add(
                    Topic(
                        "Грамматика",
                        "Изучайте правила грамматики",
                        66,
                        i,
                        background = R.drawable.first_them_bg,
                        image = R.drawable.grammar_img
                    )
                )
            } else {
                x.add(
                    Topic(
                        "Упражнения",
                        "Делайте упражнения",
                        46,
                        i,
                        background = R.drawable.first_them_bg,
                        image = R.drawable.exercise_img
                    )
                )
            }
        }
        return TopicsState(x)
    }

//    private fun getTopicState(): TopicsState =
//        TopicsState(
//            topics = listOf(
//                Topic(
//                    "Грамматика",
//                    "Изучайте правила грамматики",
//                    66,
//                    0,
//                    background = R.drawable.first_them_bg,
//                    image = R.drawable.grammar_img
//                ),
//                Topic(
//                    "Упражнения",
//                    "Делайте упражнения",
//                    46,
//                    1,
//                    background = R.drawable.first_them_bg,
//                    image = R.drawable.exercise_img
//                ),
//                Topic(
//                    "Лексика",
//                    "Учите слова",
//                    20,
//                    id = 2,
//                    background = R.drawable.first_them_bg,
//                    image = R.drawable.vocabulary_img
//                )
//            )
//        )

}