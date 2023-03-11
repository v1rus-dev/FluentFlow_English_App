package yegor.cheprasov.feature_data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import yegor.cheprasov.feature_data.database.dao.FinishExerciseDao
import yegor.cheprasov.feature_data.database.entities.FinishExercise

@Database(entities = [FinishExercise::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun finishExerciseDao(): FinishExerciseDao

}

//Write me query to room database on kotlin with coroutines