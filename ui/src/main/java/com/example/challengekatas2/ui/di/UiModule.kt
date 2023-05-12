package com.example.challengekatas2.ui.di

import com.example.challengekatas2.domain.usecase.DeleteReminderByIdUseCase
import com.example.challengekatas2.domain.usecase.GetAllRemindersUseCase
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import com.example.challengekatas2.domain.usecase.CreateReminderUseCase
import com.example.challengekatas2.domain.usecase.GetReminderByIdUseCase
import com.example.challengekatas2.ui.reminder.viewmodels.CreateReminderViewModel
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderDetailViewModel
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UiModule {

    @Provides
    fun provideCreateReminderViewModel(
        createReminderUseCase: CreateReminderUseCase
    ): CreateReminderViewModel {
        return CreateReminderViewModel(createReminderUseCase)
    }

    @Provides
    fun provideReminderDetailViewModel(
        getReminderByIdUseCase: GetReminderByIdUseCase
    ): ReminderDetailViewModel {
        return ReminderDetailViewModel(getReminderByIdUseCase)
    }

    @Provides
    fun provideReminderListViewModel(
        getAllRemindersUseCase: GetAllRemindersUseCase,
        deleteReminderByIdUseCase: DeleteReminderByIdUseCase
    ): ReminderListViewModel {
        return ReminderListViewModel(getAllRemindersUseCase, deleteReminderByIdUseCase)
    }
}