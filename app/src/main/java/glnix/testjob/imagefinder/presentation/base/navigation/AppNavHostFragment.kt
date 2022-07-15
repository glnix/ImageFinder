package glnix.testjob.imagefinder.presentation.base.navigation

import ChromeCustomTabsNavigator
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign

class AppNavHostFragment : NavHostFragment() {

    override fun onCreateNavController(navController: NavController) {
        super.onCreateNavController(navController)

        context?.let {
            navController.navigatorProvider += ChromeCustomTabsNavigator(
                it
            )
        }
    }

}