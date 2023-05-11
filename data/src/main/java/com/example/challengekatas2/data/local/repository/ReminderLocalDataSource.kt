package com.example.challengekatas2.data.local.repository

import com.example.challengekatas2.data.local.dao.ReminderDao
import com.example.challengekatas2.data.mapper.ReminderMapper
import com.example.challengekatas2.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ReminderLocalDataSource @Inject constructor(private val reminderDao: ReminderDao) {

    fun getReminders(): Flow<List<Reminder>> {
        return flow { ReminderMapper.mapToReminderDomainList(reminderDao.getReminders().first()) }

    }

    suspend fun saveReminders(reminders: List<Reminder>) {
        val entities = ReminderMapper.mapToReminderEntityList(reminders)
        reminderDao.saveReminders(entities)
    }
}