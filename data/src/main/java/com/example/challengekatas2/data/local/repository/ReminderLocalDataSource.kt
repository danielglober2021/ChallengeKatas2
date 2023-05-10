package com.example.challengekatas2.data.local.repository

import com.example.challengekatas2.data.entity.ReminderEntity
import com.example.challengekatas2.data.local.dao.ReminderDao
import com.example.challengekatas2.domain.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ReminderLocalDataSource @Inject constructor(private val reminderDao: ReminderDao) {

    fun getReminders(): Flow<List<Reminder>> {
        return reminderDao.getReminders().map { entities ->
            entities.map { entity ->
                Reminder(
                    id = entity.id,
                    title = entity.title,
                    description = entity.description,
                    date = entity.date,
                    time = entity.time
                )
            }
        }
    }

    suspend fun saveReminders(reminders: List<Reminder>) {
        val entities = reminders.map { reminder ->
            ReminderEntity(
                id = reminder.id,
                title = reminder.title,
                description = reminder.description,
                date = reminder.date,
                time = reminder.time
            )
        }
        reminderDao.saveReminders(entities)
    }
}