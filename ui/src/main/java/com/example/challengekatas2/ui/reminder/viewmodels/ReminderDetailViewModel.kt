package com.example.challengekatas2.ui.reminder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.domain.usecase.GetReminderByIdUseCase
import com.example.challengekatas2.utils.Result as CustomResult
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

    private val _reminder = MutableStateFlow<CustomResult<Reminder?>>(CustomResult.Loading)
    val reminder: StateFlow<CustomResult<Reminder?>> = _reminder

    fun getReminderById(id: Long) {
        viewModelScope.launch {
            val reminder = getReminderByIdUseCase.invoke(id).first()
            if (reminder != null)
                _reminder.value = CustomResult.Success(reminder)
            else
                _reminder.value = CustomResult.Error(errorMessage = "No reminder with that id")
        }
    }
}