package pl.mateuszkrawczuk.githubclient.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_post_results.*
import pl.mateuszkrawczuk.githubclient.R
import pl.mateuszkrawczuk.githubclient.databinding.FragmentPostResultsBinding
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo
import javax.inject.Inject

class UserSearchFragment : DaggerFragment() {

    companion object {
        fun newInstance() =
            UserSearchFragment()
    }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPostResultsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_post_results, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private var disposables = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewAdapter = RepositoriesAdapter()
        reposList.layoutManager = LinearLayoutManager(requireContext())
        reposList.adapter = viewAdapter

        viewModel.repositories.observe(
            viewLifecycleOwner,
            Observer<List<RepositoryInfo>> { viewAdapter.setItems(it) }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}
