package com.mf.hcs.gitappusers.data.repository

import com.mf.hcs.gitappusers.data.api.GitHubApiService
import com.mf.hcs.gitappusers.domain.model.GitHubUser
import com.mf.hcs.gitappusers.domain.model.SearchResponse
import com.mf.hcs.gitappusers.domain.repository.GitHubRepository
import com.mf.hcs.gitappusers.localdatabase.dao.GitHubUserDao
import com.mf.hcs.gitappusers.localdatabase.entity.GitHubUserEntity
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val api: GitHubApiService,
    private val dao: GitHubUserDao
) : GitHubRepository {

    override suspend fun searchUsers(query: String): SearchResponse {
        val result = api.searchUsers(query)
        val entities = result.items.map { it.toEntity() }
        dao.clearUsers()
        dao.insertUsers(entities)
        return result
    }

    override suspend fun getUserDetail(username: String): GitHubUser {
        TODO("Not yet implemented")
    }

    override suspend fun getUsers(): List<GitHubUser> {
        val remoteUsers = api.getUsers()
        val entities = remoteUsers.map { it.toEntity() }
        dao.clearUsers()
        dao.insertUsers(entities)
        return entities.map { it.toDomain() }
    }

    private fun GitHubUser.toEntity() = GitHubUserEntity(
        id, login, avatarUrl, url, htmlUrl, type, name, bio, followers, following
    )

    private fun GitHubUserEntity.toDomain() = GitHubUser(
        login, id, avatar_url, url, html_url, type, name, bio, followers, following
    )
}