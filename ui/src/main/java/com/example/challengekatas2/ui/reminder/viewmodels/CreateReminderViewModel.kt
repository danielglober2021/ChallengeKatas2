package com.example.challengekatas2.ui.reminder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.utils.Result as CustomResult
import com.example.challengekatas2.domain.usecase.CreateReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateReminderViewModel @Inject constructor( private val createReminderUseCase: CreateReminderUseCase) : ViewModel() {

    private val _createReminderFlow = MutableStateFlow<CustomResult<Unit>>(CustomResult.Loading)
    val createReminder: StateFlow<CustomResult<Unit>> = _createReminderFlow

    fun createReminder(title: String, description: String, type: String, date: String, time: String) {
        viewModelScope.launch {
            if (createReminderUseCase.invoke(Reminder(0, title, description, type, date, time)))
                _createReminderFlow.emit(CustomResult.Success(Unit))
            else
                _createReminderFlow.emit(CustomResult.Error("Failed reminder creation!"))
        }
    }
}