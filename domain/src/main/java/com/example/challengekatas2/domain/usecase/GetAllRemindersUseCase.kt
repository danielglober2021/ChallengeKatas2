package com.example.challengekatas2.domain.usecase

import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.repository.ReminderRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllRemindersUseCase @Inject constructor(
    private val reminderRepository: ReminderRepository,
    coroutineDispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, Flow<List<Reminder?>>, >(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit): Flow<List<Reminder?>> {
        return reminderRepository.getAllReminders()
    }
}