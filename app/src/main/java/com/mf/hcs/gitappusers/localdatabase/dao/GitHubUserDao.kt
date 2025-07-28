package com.mf.hcs.gitappusers.localdatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.hcs.gitappusers.localdatabase.entity.GitHubUserEntity

@Dao
interface GitHubUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<GitHubUserEntity>)

    @Query("SELECT * FROM github_users")
    suspend fun getAllUsers(): List<GitHubUserEntity>

    @Query("DELETE FROM github_users")
    suspend fun clearUsers()
}