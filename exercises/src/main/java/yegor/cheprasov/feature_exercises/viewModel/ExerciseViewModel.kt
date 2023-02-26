package yegor.cheprasov.feature_exercises.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_data.usecases.ExerciseUseCase
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val exerciseUseCase: ExerciseUseCase
) : ViewModel() {

    

}