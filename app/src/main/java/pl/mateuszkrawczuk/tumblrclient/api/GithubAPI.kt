package pl.mateuszkrawczuk.tumblrclient.api

import io.reactivex.Single
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("users/{userName}/repos")
    fun getUserReposList(@Path("userName") userName: String): Single<List<RepositoryInfo>>
}