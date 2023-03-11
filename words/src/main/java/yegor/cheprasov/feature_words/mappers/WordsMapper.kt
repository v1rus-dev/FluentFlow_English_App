package yegor.cheprasov.feature_words.mappers

import yegor.cheprasov.feature_data.entities.ResultWords
import yegor.cheprasov.feature_data.entities.WordsFromFile
import yegor.cheprasov.feature_data.entities.WordsFromFileEntity
import yegor.cheprasov.feature_words.state.ResultWordsViewEntity
import yegor.cheprasov.feature_words.state.WordsFromFileViewEntity
import yegor.cheprasov.feature_words.state.WordsViewEntity
import javax.inject.Inject

class WordsMapper @Inject constructor() {
    fun map(it: ResultWords, learnedWords: Int): ResultWordsViewEntity =
        ResultWordsViewEntity(
            title = it.title,
            imagePath = it.imagePath,
            allWords = if (it.words.list.isEmpty()) {
                1
            } else {
                it.words.list.size
            },
            learnedWords = learnedWords,
            words = mapWordsFromFileViewEntity(it.words)
        )

    private fun mapWordsFromFileViewEntity(wordsFromFile: WordsFromFile): WordsFromFileViewEntity =
        WordsFromFileViewEntity(list = wordsFromFile.list.map { mapWordsViewEntity(it) })

    private fun mapWordsViewEntity(wordsFromFileEntity: WordsFromFileEntity): WordsViewEntity =
        WordsViewEntity(wordsFromFileEntity.word, wordsFromFileEntity.translate)
}