package yegor.cheprasov.feature_design.tools

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    private val mutableNavigateToGrammar = MutableSharedFlow<Unit>()
    val navigateToGrammar: Flow<Unit> = mutableNavigateToGrammar
    init {
        Log.d("myTag", "sharedViewModel init")
    }

    fun navigateToGrammar() = viewModelScope.launch {
        mutableNavigateToGrammar.emit(Unit)
    }

}