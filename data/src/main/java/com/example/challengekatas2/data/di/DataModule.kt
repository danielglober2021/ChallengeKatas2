package com.example.challengekatas2.data.di

import android.content.Context
import androidx.room.Room
import com.example.challengekatas2.data.local.dao.ReminderDao
import com.example.challengekatas2.data.local.db.AppDatabase
import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.mapper.ReminderMapper
import com.example.challengekatas2.data.repository.ReminderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideReminderDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context.applicationContext)
    }

    @Provides
    @Singleton
    fun provideReminderDao(database: AppDatabase): ReminderDao {
        return database.reminderDao()
    }

    @Provides
    fun provideReminderLocalDataSource(reminderDao: ReminderDao): ReminderLocalDataSource {
        return ReminderLocalDataSource(reminderDao)
    }

    @Provides
    fun provideReminderRepository(
        localDataSource: ReminderLocalDataSource
    ): ReminderRepository {
        return ReminderRepository(localDataSource)
    }

    @Provides
    fun provideReminderMapper(): ReminderMapper {
        return ReminderMapper
    }
}