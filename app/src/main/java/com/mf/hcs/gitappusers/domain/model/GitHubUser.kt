package com.mf.hcs.gitappusers.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubUser(
    @Json(name = "login") val login: String,
    @Json(name = "id") val id: Int,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "url") val url: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String?,
    @Json(name = "bio") val bio: String?,
    @Json(name = "followers") val followers: Int?,
    @Json(name = "following") val following: Int?
)