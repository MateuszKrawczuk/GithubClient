package pl.mateuszkrawczuk.tumblrclient.ui.main.usecase

import io.reactivex.rxjava3.core.Single
import pl.mateuszkrawczuk.tumblrclient.api.GithubAPI
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo

class GetAllUserReposUseCaseImpl(private val githubAPI: GithubAPI) :
    GetAllUserReposUseCase {

    override fun execute(userName: String): Single<List<RepositoryInfo>> =
        githubAPI.getUserReposList(userName)
            .onErrorReturn { emptyList() }
}