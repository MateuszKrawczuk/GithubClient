package pl.mateuszkrawczuk.tumblrclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_screen, container, false)
    }

    override fun onStart() {
        super.onStart()
        launchMainMenu()
    }

    fun launchMainMenu() {

        val navController =
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        viewLifecycleOwner.lifecycleScope.launch {
            delay(2200L)
            navController.navigate(R.id.action_welcomeScreenFragment_to_mainMenuFragment2)
        }
    }
}
