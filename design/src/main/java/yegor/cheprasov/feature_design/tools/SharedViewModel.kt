package yegor.cheprasov.feature_design.tools

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    init {
        Log.d("myTag", "sharedViewModel init")
    }

}