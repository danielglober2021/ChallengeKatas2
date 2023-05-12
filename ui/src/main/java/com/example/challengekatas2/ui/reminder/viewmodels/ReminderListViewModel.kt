package com.example.challengekatas2.ui.reminder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.usecase.DeleteReminderByIdUseCase
import com.example.challengekatas2.domain.usecase.GetAllRemindersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderListViewModel @Inject constructor(
    private val getAllRemindersUseCase: GetAllRemindersUseCase,
    private val deleteReminderByIdUseCase: DeleteReminderByIdUseCase,
) : ViewModel() {

    private val _reminders: MutableStateFlow<List<Reminder?>> = MutableStateFlow(emptyList())
    val reminders: StateFlow<List<Reminder?>> get() = _reminders

    init {
        fetchReminders()
    }


    private fun fetchReminders() {
        viewModelScope.launch {
            getAllRemindersUseCase
                .invoke(Unit)
                .mapNotNull { it } // Delete null elements from flow
                .collectLatest { reminders ->
                    _reminders.value = reminders
                }
        }
    }

    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch {
            deleteReminderByIdUseCase.invoke(reminder.id)
            fetchReminders()
        }
    }
}