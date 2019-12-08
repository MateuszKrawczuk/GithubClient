package pl.mateuszkrawczuk.tumblrclient.ui.main.usecase

import io.reactivex.Single
import pl.mateuszkrawczuk.tumblrclient.api.GithubAPI
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo

class GetAllRepoListCaseImpl(private val githubAPI: GithubAPI) :
    GetAllRepoListCase {

    override fun execute(repoName: String): Single<List<RepositoryInfo>> =
        githubAPI.getUserReposList(repoName)
            .onErrorReturn { emptyList() }
}