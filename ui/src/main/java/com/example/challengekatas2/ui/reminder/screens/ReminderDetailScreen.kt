package com.example.challengekatas2.ui.reminder.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderDetailViewModel

@Composable
fun ReminderDetailScreen(
    reminderId: Long,
    navController: NavController
) {

    val viewModel: ReminderDetailViewModel = hiltViewModel()
    viewModel.getReminderById(reminderId)

}