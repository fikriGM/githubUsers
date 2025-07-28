package com.mf.hcs.gitappusers.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mf.hcs.gitappusers.localdatabase.dao.GitHubUserDao
import com.mf.hcs.gitappusers.localdatabase.entity.GitHubUserEntity

@Database(
    entities = [GitHubUserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gitHubUserDao(): GitHubUserDao
}