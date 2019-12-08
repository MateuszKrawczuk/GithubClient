package pl.mateuszkrawczuk.tumblrclient.ui.main.usecase

import io.reactivex.Single
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo

interface GetAllRepoListCase {
    fun execute(repoName: String): Single<List<RepositoryInfo>>
}