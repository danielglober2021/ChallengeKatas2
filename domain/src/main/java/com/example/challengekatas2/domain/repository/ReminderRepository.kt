package com.example.challengekatas2.domain.repository

import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ReminderRepository(
    private val reminderLocalDataSource: ReminderLocalDataSource
) {
    suspend fun createReminder(reminder: Reminder) {
        try {
            reminderLocalDataSource.saveSingleReminder(reminder)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun updateReminder(reminder: Reminder) {
        try {
            reminderLocalDataSource.updateReminder(reminder)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun deleteReminder(idReminder: Int) {
        try {
            reminderLocalDataSource.deleteReminderById(idReminder)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getAllReminders(): Flow<List<Reminder?>> {
        return try {
            reminderLocalDataSource.getAllReminders()
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(listOf(null))
        }
    }

    suspend fun getReminderById(idReminder: Long): Flow<Reminder?> {
        return try {
            reminderLocalDataSource.getReminderById(idReminder)
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf()
        }
    }
}