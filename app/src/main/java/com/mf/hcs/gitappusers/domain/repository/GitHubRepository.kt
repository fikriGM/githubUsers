package com.mf.hcs.gitappusers.domain.repository

import com.mf.hcs.gitappusers.domain.model.GitHubUser
import com.mf.hcs.gitappusers.domain.model.SearchResponse


interface GitHubRepository {
    suspend fun searchUsers(query: String): SearchResponse
    suspend fun getUserDetail(username: String): GitHubUser
    suspend fun getUsers(): List<GitHubUser>
}