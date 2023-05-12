package com.example.challengekatas2.data.local.repository

import com.example.challengekatas2.data.local.dao.ReminderDao
import com.example.challengekatas2.data.mapper.ReminderMapper
import com.example.challengekatas2.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class ReminderLocalDataSource @Inject constructor(private val reminderDao: ReminderDao) {

    fun getAllReminders(): Flow<List<Reminder?>> {
        return flow { ReminderMapper.mapToReminderDomainList(reminderDao.getAllReminders().first()) }
    }

    suspend fun getReminderById(idReminder: Long): Flow<Reminder?> {
        return reminderDao.getReminderById(idReminder).first().run {
            when (this@run != null){
                true -> flow { ReminderMapper.mapToReminderDomain(this@run) }
                false -> flowOf()
            }
        }
    }

    suspend fun saveReminders(reminders: List<Reminder>) {
        val entities = ReminderMapper.mapToReminderEntityList(reminders)
        reminderDao.saveReminders(entities)
    }

    suspend fun saveSingleReminder(reminder: Reminder) {
        val entity = ReminderMapper.mapToReminderEntity(reminder)
        reminderDao.saveSingleReminder(entity)
    }

    suspend fun updateReminder(reminder: Reminder) {
        val entity = ReminderMapper.mapToReminderEntity(reminder)
        reminderDao.updateReminder(entity)
    }

    suspend fun deleteReminderById(idReminder: Int) {
        reminderDao.deleteReminderById(idReminder)
    }
}