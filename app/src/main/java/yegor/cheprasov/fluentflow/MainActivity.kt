package yegor.cheprasov.fluentflow

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import yegor.cheprasov.feature_design.GlobalDestinations
import yegor.cheprasov.feature_design.SharedViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels { this.defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeToNavigate()
    }

    private fun subscribeToNavigate() {
        lifecycleScope.launch {
            sharedViewModel.navigateTo.collect { destination ->
                when(destination) {
                    GlobalDestinations.Grammar -> {
                        findNavController(R.id.main_nav_host_fragment).navigate(MainFragmentDirections.mainFragmentToGrammarFragment())
                    }
                    GlobalDestinations.Game -> {
                        Toast.makeText(this@MainActivity, "Navigate to exercise", Toast.LENGTH_SHORT).show()
                    }
                    GlobalDestinations.Words -> {
                        Toast.makeText(this@MainActivity, "Navigate to exercise", Toast.LENGTH_SHORT).show()
                    }
                    GlobalDestinations.None -> {
                        findNavController(R.id.main_nav_host_fragment).navigate(MainFragmentDirections.navigateToMainFragment())
                    }
                }
            }
        }
    }
}