package yegor.cheprasov.fluentflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import yegor.cheprasov.feature_design.components.AppBottomNavigation
import yegor.cheprasov.fluentflow.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        (binding.bottomNavigation as ComposeView).setContent {
            AppBottomNavigation(onClick = {
                Toast.makeText(requireContext(), "Clicked to: ${it.label}", Toast.LENGTH_SHORT).show()
            })
        }
    }
}