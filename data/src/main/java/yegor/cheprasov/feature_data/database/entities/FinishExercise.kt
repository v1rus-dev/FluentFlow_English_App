package yegor.cheprasov.feature_data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val FINISH_EXERCISE_TABLE = "finish_exercise"

@Entity(tableName = FINISH_EXERCISE_TABLE)
data class FinishExercise(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val exerciseId: String
)