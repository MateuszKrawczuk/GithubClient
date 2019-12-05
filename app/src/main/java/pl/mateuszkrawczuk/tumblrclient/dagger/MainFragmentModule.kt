package pl.mateuszkrawczuk.tumblrclient.dagger

import dagger.Module
import dagger.Provides
import pl.mateuszkrawczuk.tumblrclient.api.TumblrAPI
import pl.mateuszkrawczuk.tumblrclient.usecase.GetAllUseCase
import pl.mateuszkrawczuk.tumblrclient.usecase.GetAllUseCaseImpl

@Module
object MainFragmentModule {

    @Provides
    fun provideGetAllUseCase(tumblrAPI: TumblrAPI): GetAllUseCase =
        GetAllUseCaseImpl(tumblrAPI)
}