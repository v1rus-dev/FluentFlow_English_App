package yegor.cheprasov.feature_data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import yegor.cheprasov.feature_data.database.entities.FINISH_EXERCISE_TABLE
import yegor.cheprasov.feature_data.database.entities.FinishExercise

@Dao
interface FinishExerciseDao {

    @Insert
    suspend fun insert(finishExercise: FinishExercise)

    @Query("SELECT EXISTS(SELECT * FROM $FINISH_EXERCISE_TABLE WHERE exerciseId = :id)")
    suspend fun isIdExists(id: String): Boolean

    @Query("DELETE FROM $FINISH_EXERCISE_TABLE WHERE exerciseId = :id")
    suspend fun removeById(id: String)

    @Query("DELETE FROM $FINISH_EXERCISE_TABLE")
    suspend fun removeAll()
}