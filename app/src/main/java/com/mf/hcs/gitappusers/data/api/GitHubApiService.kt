package com.mf.hcs.gitappusers.data.api

import com.mf.hcs.gitappusers.domain.model.GitHubUser
import com.mf.hcs.gitappusers.domain.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): SearchResponse

    @GET("users")
    suspend fun getUsers(): List<GitHubUser>

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): GitHubUser
}