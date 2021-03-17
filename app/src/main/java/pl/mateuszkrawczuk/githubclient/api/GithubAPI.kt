package pl.mateuszkrawczuk.githubclient.api

import io.reactivex.rxjava3.core.Single
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("users/{userName}/repos")
    fun getUserReposList(@Path("userName") userName: String): Single<List<RepositoryInfo>>
}