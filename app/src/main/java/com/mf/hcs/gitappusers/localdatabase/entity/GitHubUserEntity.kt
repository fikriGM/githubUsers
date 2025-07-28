package com.mf.hcs.gitappusers.localdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_users")
data class GitHubUserEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val avatar_url: String,
    val url: String,
    val html_url: String,
    val type: String,
    val name: String?,
    val bio: String?,
    val followers: Int?,
    val following: Int?
)