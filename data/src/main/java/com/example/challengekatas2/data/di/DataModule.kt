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

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideReminderDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "reminders.db"
        ).build()
    }

    @Provides
    fun provideReminderDao(database: AppDatabase): ReminderDao {
        return database.reminderDao()
    }

    @Provides
    fun provideReminderLocalDataSource(reminderDao: ReminderDao): ReminderLocalDataSource {
        return ReminderLocalDataSource(reminderDao)
    }

    @Provides
    fun provideReminderRepository(
        localDataSource: ReminderLocalDataSource,
        mapper: ReminderMapper
    ): ReminderRepository {
        return ReminderRepository(localDataSource,  mapper)
    }

    @Provides
    fun provideReminderMapper(): ReminderMapper {
        return ReminderMapper()
    }
}