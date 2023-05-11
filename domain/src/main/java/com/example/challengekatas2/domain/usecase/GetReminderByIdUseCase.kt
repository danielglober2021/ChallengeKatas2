package com.example.challengekatas2.domain.usecase

import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.repository.ReminderRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetReminderByIdUseCase @Inject constructor(
    private val reminderRepository: ReminderRepository,
    coroutineDispatcher: CoroutineDispatcher
) : BaseUseCase<String, Flow<Reminder?>>(coroutineDispatcher) {

    data class Params(val id: Int)

    override suspend fun execute(idReminder: String): Flow<Reminder?> {
        return reminderRepository.getReminderById(idReminder)
    }
}