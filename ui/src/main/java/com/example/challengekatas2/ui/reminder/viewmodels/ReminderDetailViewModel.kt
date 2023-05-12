package com.example.challengekatas2.ui.reminder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.usecase.DeleteReminderByIdUseCase
import com.example.challengekatas2.domain.usecase.GetReminderByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderDetailViewModel @Inject constructor(
    private val getReminderByIdUseCase: GetReminderByIdUseCase,
    ) : ViewModel() {

    private val _reminder = MutableStateFlow<Reminder?>(null)
    val reminder: StateFlow<Reminder?> = _reminder

    fun getReminderById(id: Long) {
        viewModelScope.launch {
            val reminder = getReminderByIdUseCase.invoke(id).first()
            _reminder.value = reminder
        }
    }
}