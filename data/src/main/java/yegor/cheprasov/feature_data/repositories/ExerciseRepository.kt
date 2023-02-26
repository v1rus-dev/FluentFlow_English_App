package yegor.cheprasov.feature_data.repositories

import yegor.cheprasov.feature_data.database.dao.FinishExerciseDao
import yegor.cheprasov.feature_data.database.entities.FinishExercise
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val exerciseDao: FinishExerciseDao
) {

    suspend fun insert(finishExercise: FinishExercise) = exerciseDao.insert(finishExercise)

    suspend fun isIdExists(id: String): Boolean = exerciseDao.isIdExists(id)

    suspend fun removeById(id: String): Boolean = exerciseDao.removeById(id)

    suspend fun removeAll() = exerciseDao.removeAll()

}