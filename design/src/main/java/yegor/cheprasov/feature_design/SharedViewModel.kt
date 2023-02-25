package yegor.cheprasov.feature_design

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    private val mutableNavigateGlobal = MutableSharedFlow<GlobalDestinations>()
    val navigateTo: Flow<GlobalDestinations> = mutableNavigateGlobal

    fun navigateTo(globalDestination: GlobalDestinations) = viewModelScope.launch {
        mutableNavigateGlobal.emit(globalDestination)
    }
}