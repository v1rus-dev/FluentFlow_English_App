package yegor.cheprasov.feature_admin_screens.screens.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d("myTag", "admin mainViewModel init")
    }

}