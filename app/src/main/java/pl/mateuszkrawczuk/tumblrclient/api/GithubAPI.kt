package pl.mateuszkrawczuk.tumblrclient.api

import io.reactivex.Single
import pl.mateuszkrawczuk.tumblrclient.models.CommitInfo
import pl.mateuszkrawczuk.tumblrclient.models.RepositoryInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("users/{userName}/repos")
    fun getUserReposList(@Path("userName") userName: String): Single<List<RepositoryInfo>>

    @GET("/search/commits/{commits}")
    fun getCommitsList(@Path("commits") commits: String): Single<List<CommitInfo>>

    @GET("/search/repository/{repoName}")
    fun getRepoList(@Path("repoName") repoName: String): Single<List<RepositoryInfo>>
}