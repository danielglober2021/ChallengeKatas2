package com.example.challengekatas2.ui.reminder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.usecase.CreateReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateReminderViewModel @Inject constructor( private val createReminderUseCase: CreateReminderUseCase) : ViewModel() {

    fun createReminder(title: String, description: String, date: Long, time: Long) {
        viewModelScope.launch {
            createReminderUseCase.invoke(Reminder(0, title, description, date, time))
        }
    }
}