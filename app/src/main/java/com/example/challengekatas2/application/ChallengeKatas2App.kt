package com.example.challengekatas2.application

import android.app.Application
import com.example.challengekatas2.domain.repository.ReminderRepository
import com.example.challengekatas2.domain.usecase.*
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ChallengeKatas2App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    @Inject
    lateinit var reminderDomainRepository: ReminderRepository

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