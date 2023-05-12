package com.example.challengekatas2.ui.reminder.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challengekatas2.utils.Result as CustomResult
import androidx.navigation.NavController
import com.example.challengekatas2.data.model.Reminder
import com.example.challengekatas2.ui.reminder.viewmodels.ReminderDetailViewModel
import com.example.challengekatas2.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun ReminderDetailScreen(
    reminderId: Long,
    navController: NavController
) {

    val viewModel: ReminderDetailViewModel = hiltViewModel()
    val reminderState by viewModel.reminder.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Reminder detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = {
            when (val result = reminderState) {
                is CustomResult.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is CustomResult.Success -> {
                    result.data?.let {
                        showReminderDetail(it)
                    } ?: run {
                        Text(text = "Reminder not found")
                    }
                }
                is CustomResult.Error -> {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(result.errorMessage ?: "")
                        navController.popBackStack()
                    }
                }
            }
        }
    )

    viewModel.getReminderById(reminderId)
}

@Composable
fun showReminderDetail(reminder: Reminder) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Title: " + reminder.title, style = Typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Description: " + reminder.description, style = Typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Type: " + reminder.type, style = Typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Date: " + reminder.date, style = Typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Time: " + reminder.time, style = Typography.h4)
    }
}