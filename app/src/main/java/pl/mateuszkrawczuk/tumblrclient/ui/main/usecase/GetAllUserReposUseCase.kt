package pl.mateuszkrawczuk.tumblrclient.ui.main.usecase

import io.reactivex.rxjava3.core.Single
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo

interface GetAllUserReposUseCase {
    fun execute(userName: String): Single<List<RepositoryInfo>>
}