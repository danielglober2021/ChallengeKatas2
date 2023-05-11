package com.example.challengekatas2.data.repository

import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReminderRepository @Inject constructor(
    private val localDataSource: ReminderLocalDataSource,
    // private val remoteDataSource: ReminderRemoteDataSource,
) {

    fun getReminders(): Flow<List<Reminder?>> {
        return localDataSource.getAllReminders()

        // Code to be used with a remote data source
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