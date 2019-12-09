package pl.mateuszkrawczuk.githubclient.dagger

import dagger.Module
import dagger.Provides
import pl.mateuszkrawczuk.githubclient.api.GithubAPI
import pl.mateuszkrawczuk.githubclient.ui.main.usecase.GetAllUserReposUseCase
import pl.mateuszkrawczuk.githubclient.ui.main.usecase.GetAllUserReposUseCaseImpl

@Module
object MainFragmentModule {

    @Provides
    fun provideGetAllUseCase(githubAPI: GithubAPI): GetAllUserReposUseCase =
        GetAllUserReposUseCaseImpl(githubAPI)
}