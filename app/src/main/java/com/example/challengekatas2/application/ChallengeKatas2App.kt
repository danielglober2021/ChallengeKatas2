package com.example.challengekatas2.application

import android.app.Application
import com.example.challengekatas2.data.repository.ReminderRepository as DataReminderRepository
import com.example.challengekatas2.domain.repository.ReminderRepository as DomainReminderRepository
import com.example.challengekatas2.domain.usecase.*
import com.example.challengekatas2.ui.reminder.viewmodels.CreateReminderViewModel
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderDetailViewModel
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ChallengeKatas2App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    // UI
    @Inject
    lateinit var createReminderViewModel: CreateReminderViewModel

    @Inject
    lateinit var reminderDetailViewModel: ReminderDetailViewModel

    @Inject
    lateinit var reminderListViewModel: ReminderDetailViewModel

    // Data
    @Inject
    lateinit var reminderDataRepository: DataReminderRepository

    // Domain
    @Inject
    lateinit var reminderDomainRepository: DomainReminderRepository

    @Inject
    lateinit var getAllRemindersUseCase: GetAllRemindersUseCase

    @Inject
    lateinit var createReminderUseCase: CreateReminderUseCase

    @Inject
    lateinit var updateReminderUseCase: UpdateReminderUseCase

    @Inject
    lateinit var deleteReminderByIdUseCase: DeleteReminderByIdUseCase

    @Inject
    lateinit var getReminderByIdUseCase: GetReminderByIdUseCase
}