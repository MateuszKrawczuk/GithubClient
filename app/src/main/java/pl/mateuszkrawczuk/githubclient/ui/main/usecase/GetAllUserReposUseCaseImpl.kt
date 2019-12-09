package pl.mateuszkrawczuk.githubclient.ui.main.usecase

import io.reactivex.Single
import pl.mateuszkrawczuk.githubclient.api.GithubAPI
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo

class GetAllUserReposUseCaseImpl(private val githubAPI: GithubAPI) :
    GetAllUserReposUseCase {

    override fun execute(userName: String): Single<List<RepositoryInfo>> =
        githubAPI.getUserReposList(userName)
            .onErrorReturn { emptyList() }
}