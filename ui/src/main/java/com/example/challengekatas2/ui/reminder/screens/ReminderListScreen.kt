package com.example.challengekatas2.ui.reminder.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderListViewModel

@Composable
fun ReminderListScreen(
    navController: NavController
)  {

    val viewModel: ReminderListViewModel = hiltViewModel()
    val reminders by viewModel.reminders.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(reminders) { reminder ->
            ReminderItem(reminder)
        }
    }
}

@Composable
fun ReminderItem(reminder: Reminder?) {
    Text(text = reminder?.title ?: "")
}