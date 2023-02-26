package yegor.cheprasov.feature_admin_screens.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GrammarViewModel @Inject constructor() : ViewModel() {

    private val mutableState: MutableStateFlow<List<String>> = MutableStateFlow(getState())
    val uiState: StateFlow<List<String>>
    get() = mutableState

    private fun getState(): List<String> =
        listOf("")

    fun addExample(example: String) = viewModelScope.launch {
        val newList = arrayListOf<String>().apply {
            addAll(uiState.value)
            add(example)
        }
        mutableState.emit(newList)
    }

}