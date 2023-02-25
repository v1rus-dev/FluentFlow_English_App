package yegor.cheprasov.features_topics.fakedata

import yegor.cheprasov.features_topics.R
import yegor.cheprasov.features_topics.Topic
import yegor.cheprasov.features_topics.state.TopicsState

fun getFake(): TopicsState =
    TopicsState(
        topics = listOf(
            Topic(
                "Грамматика",
                "Изучайте правила грамматики",
                66,
                0,
                background = R.drawable.first_them_bg,
                image = R.drawable.grammar_img
            ),
            Topic(
                "Упражнения",
                "Делайте упражнения",
                46,
                1,
                background = R.drawable.first_them_bg,
                image = R.drawable.exercise_img
            ),
            Topic(
                "Игра",
                "Как много слов вы знаете?",
                20,
                id = 2,
                background = R.drawable.first_them_bg,
                image = R.drawable.vocabulary_img
            )
        )
    )