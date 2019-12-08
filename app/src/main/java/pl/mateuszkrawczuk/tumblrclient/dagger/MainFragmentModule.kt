package pl.mateuszkrawczuk.tumblrclient.dagger

import dagger.Module
import dagger.Provides
import pl.mateuszkrawczuk.tumblrclient.api.GithubAPI
import pl.mateuszkrawczuk.tumblrclient.ui.main.usecase.GetAllUserReposUseCase
import pl.mateuszkrawczuk.tumblrclient.ui.main.usecase.GetAllUserReposUseCaseImpl

@Module
object MainFragmentModule {

    @Provides
    fun provideGetAllUseCase(githubAPI: GithubAPI): GetAllUserReposUseCase =
        GetAllUserReposUseCaseImpl(githubAPI)

}