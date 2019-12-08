package pl.mateuszkrawczuk.tumblrclient.models

import com.squareup.moshi.Json

data class Owner(
    @field:Json(name = "login") val login: String,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "node_id") val node_id: String,
    @field:Json(name = "avatar_url") val avatar_url: String,
    @field:Json(name = "gravatar_id") val gravatar_id: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "html_url") val html_url: String,
    @field:Json(name = "followers_url") val followers_url: String,
    @field:Json(name = "following_url") val following_url: String,
    @field:Json(name = "gists_url") val gists_url: String,
    @field:Json(name = "starred_url") val starred_url: String,
    @field:Json(name = "subscriptions_url") val subscriptions_url: String,
    @field:Json(name = "organizations_url") val organizations_url: String,
    @field:Json(name = "repos_url") val repos_url: String,
    @field:Json(name = "events_url") val events_url: String,
    @field:Json(name = "received_events_url") val received_events_url: String,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "site_admin") val site_admin: Boolean
)