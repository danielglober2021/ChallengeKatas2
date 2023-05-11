package com.example.challengekatas2.domain.di

import com.example.challengekatas2.domain.repository.ReminderRepository
import com.example.challengekatas2.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideGetAllRemindersUseCase(
        reminderRepository: ReminderRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): GetAllRemindersUseCase = GetAllRemindersUseCase(reminderRepository, coroutineDispatcher)

    @Provides
    @Singleton
    fun provideGetReminderByIdUseCase(
        reminderRepository: ReminderRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): GetReminderByIdUseCase = GetReminderByIdUseCase(reminderRepository, coroutineDispatcher)

    @Provides
    @Singleton
    fun provideCreateReminderUseCase(
        reminderRepository: ReminderRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): CreateReminderUseCase = CreateReminderUseCase(reminderRepository, coroutineDispatcher)

    @Provides
    @Singleton
    fun provideUpdateReminderUseCase(
        reminderRepository: ReminderRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): UpdateReminderUseCase = UpdateReminderUseCase(reminderRepository, coroutineDispatcher)

    @Provides
    @Singleton
    fun provideDeleteReminderUseCase(
        reminderRepository: ReminderRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): DeleteReminderByIdUseCase = DeleteReminderByIdUseCase(reminderRepository, coroutineDispatcher)

}