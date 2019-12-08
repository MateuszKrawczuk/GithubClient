package pl.mateuszkrawczuk.tumblrclient.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main_menu.*
import pl.mateuszkrawczuk.tumblrclient.R


class MainMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchUserButton.setOnClickListener {
            disableButtons()
            it.findNavController()
                .navigate(MainMenuFragmentDirections.actionMainMenuFragmentToUserSearchFragment())
        }
        searchRepoButton.setOnClickListener {
            disableButtons()
            it.findNavController()
                .navigate(MainMenuFragmentDirections.actionMainMenuFragmentToUserSearchFragment())
        }
    }

/* TODO: Investigate and fix bug with nav framework.
     It doesn't remove/hide previous fragment from view */

    private fun disableButtons() {
        searchUserButton.visibility = View.GONE
        searchRepoButton.visibility = View.GONE
    }
}
