package pl.mateuszkrawczuk.tumblrclient.models

import com.squareup.moshi.Json

data class LicenseInfo(
    @field:Json(name = "key") val key: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "spdx_id") val spdx_id: String,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "node_id") val node_id: String
)