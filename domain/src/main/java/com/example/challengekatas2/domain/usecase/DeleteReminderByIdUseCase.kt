package com.example.challengekatas2.domain.usecase

import com.example.challengekatas2.domain.repository.ReminderRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteReminderByIdUseCase @Inject constructor(
    private val reminderRepository: ReminderRepository,
    coroutineDispatcher: CoroutineDispatcher
) : BaseUseCase<String, Unit>(coroutineDispatcher) {

    override suspend fun execute(idReminder: String) {
        reminderRepository.deleteReminder(idReminder)
    }
}