package com.example.challengekatas2.domain.usecase

import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.repository.ReminderRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateReminderUseCase @Inject constructor(
    private val reminderRepository: ReminderRepository,
    coroutineDispatcher: CoroutineDispatcher
): BaseUseCase<Reminder, Boolean>(coroutineDispatcher) {

    override suspend fun execute(params: Reminder): Boolean {
        return reminderRepository.createReminder(params)
    }
}