package com.example.challengekatas2.data.repository

import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.mapper.ReminderMapper
import com.example.challengekatas2.domain.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReminderRepository @Inject constructor(
    private val localDataSource: ReminderLocalDataSource,
    // private val remoteDataSource: ReminderRemoteDataSource,
) {

    fun getReminders(): Flow<List<Reminder>> {
        return localDataSource.getReminders()
        /*return localDataSource.getReminders().flatMapConcat { reminders ->
            if (reminders.isEmpty()) {
                fetchRemindersAndSaveLocally()
                localDataSource.getReminders()
            } else {
                flowOf(reminders)
            }
        }*/
    }

    /*private suspend fun fetchRemindersAndSaveLocally() {
        // This part is not functional
        /*val reminders = remoteDataSource.getReminders()
        localDataSource.saveReminders(reminders)*/
    }*/
}