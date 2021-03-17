package pl.mateuszkrawczuk.tumblrclient.dagger

import dagger.Module
import dagger.Provides
import pl.mateuszkrawczuk.tumblrclient.api.GithubAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


const val URL_SERVER = "https://api.github.com/"

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL_SERVER)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): GithubAPI = retrofit.create(GithubAPI::class.java)
}