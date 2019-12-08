package pl.mateuszkrawczuk.tumblrclient.ui.main

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
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_post_results.*
import pl.mateuszkrawczuk.tumblrclient.R
import pl.mateuszkrawczuk.tumblrclient.databinding.FragmentPostResultsBinding
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo
import javax.inject.Inject

class PostResultsFragment : DaggerFragment() {

    companion object {
        fun newInstance() =
            PostResultsFragment()
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
            this,
            Observer<List<RepositoryInfo>> { viewAdapter.setItems(it) }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}
