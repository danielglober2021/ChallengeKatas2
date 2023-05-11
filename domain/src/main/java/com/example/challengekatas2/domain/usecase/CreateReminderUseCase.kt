package com.example.challengekatas2.domain.usecase

import com.example.challengekatas2.domain.repository.ReminderRepository
import kotlinx.coroutines.CoroutineDispatcher

class CreateReminderUseCase(
    private val reminderRepository: ReminderRepository,
    coroutineDispatcher: CoroutineDispatcher
): BaseUseCase<Reminder, Unit>(coroutineDispatcher) {

    override suspend fun execute(params: Reminder) {
        reminderRepository.createReminder(params)
    }
}