package pl.mateuszkrawczuk.githubclient.ui.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo
import pl.mateuszkrawczuk.githubclient.ui.main.usecase.GetAllUserReposUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getAllUserRepos: GetAllUserReposUseCase) :
    ViewModel() {

    val userName = MutableLiveData<String>()

    val repositories = MutableLiveData<List<RepositoryInfo>>()

    val isLoading = MutableLiveData<Boolean>()

    private var disposables: Disposable? = null

    fun showRepos() {
        val user = userName.value
        if (user.isNullOrBlank()) return

        fetchUserRepos(user)
    }

    private fun fetchUserRepos(user: String) {
        disposables?.dispose()
        disposables = getAllUserRepos.execute(user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                isLoading.value = true
            }
            .subscribe { items ->
                repositories.value = items
                isLoading.value = false
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposables?.dispose()
    }
}
