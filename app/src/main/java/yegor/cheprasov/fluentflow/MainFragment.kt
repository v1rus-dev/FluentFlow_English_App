package yegor.cheprasov.fluentflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import yegor.cheprasov.feature_design.components.AppBottomNavigation
import yegor.cheprasov.feature_design.components.BottomNavItem
import yegor.cheprasov.fluentflow.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setContent {
            AppBottomNavigation(onClick = { bottomNavItem ->
                when(bottomNavItem) {
                    BottomNavItem.Topics -> {
                        binding.navHostFragment.findNavController().navigateSafe(R.id.to_topics_nav_graph)
                    }
                    BottomNavItem.Words -> {
                        binding.navHostFragment.findNavController().navigateSafe(R.id.to_words_nav_graph)
                    }
                    BottomNavItem.Profile -> {
                    }
                }
            })
        }
    }
}

fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}