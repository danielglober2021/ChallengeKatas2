package com.example.challengekatas2.domain.repository

import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ReminderRepository(
    private val reminderLocalDataSource: ReminderLocalDataSource
) {
    suspend fun createReminder(reminder: Reminder): Boolean {
        return try {
            reminderLocalDataSource.saveSingleReminder(reminder)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun updateReminder(reminder: Reminder): Boolean {
        return try {
            reminderLocalDataSource.updateReminder(reminder)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    suspend fun deleteReminder(idReminder: Int): Boolean {
        return try {
            reminderLocalDataSource.deleteReminderById(idReminder)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
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