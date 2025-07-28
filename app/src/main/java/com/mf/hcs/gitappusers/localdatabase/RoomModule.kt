package com.mf.hcs.gitappusers.localdatabase

import android.content.Context
import androidx.room.Room
import com.mf.hcs.gitappusers.localdatabase.dao.GitHubUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "github_user_db"
        ).build()
    }

    @Provides
    fun provideGitHubUserDao(db: AppDatabase): GitHubUserDao {
        return db.gitHubUserDao()
    }
}