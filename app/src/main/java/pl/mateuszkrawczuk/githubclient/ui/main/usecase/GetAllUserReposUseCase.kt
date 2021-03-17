package pl.mateuszkrawczuk.githubclient.ui.main.usecase

import io.reactivex.rxjava3.core.Single
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo

interface GetAllUserReposUseCase {
    fun execute(userName: String): Single<List<RepositoryInfo>>
}