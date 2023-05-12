package com.example.challengekatas2.ui.reminder.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.challengekatas2.ui.reminder.viewmodels.CreateReminderViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "FlowOperatorInvokedInComposition",
    "CoroutineCreationDuringComposition"
)
@Composable
fun CreateReminderScreen(
    navController: NavController
) {
    val viewModel: CreateReminderViewModel = hiltViewModel()
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val type = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }

    val isNameValid = name.value.isNotEmpty()
    val isDescriptionValid = name.value.isNotEmpty()
    val isDateValid = date.value.isNotEmpty()
    val isTimeValid = time.value.isNotEmpty()

    val isFormValid = isNameValid && isDateValid && isTimeValid

    val scaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Reminder") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Name") },
                    isError = !isNameValid
                )
                OutlinedTextField(
                    value = description.value,
                    onValueChange = { name.value = it },
                    label = { Text("Description") },
                    isError = !isDescriptionValid
                )
                OutlinedTextField(
                    value = type.value,
                    onValueChange = { type.value = it },
                    label = { Text("Type") },
                    isError = !isDescriptionValid
                )
                OutlinedTextField(
                    value = date.value,
                    onValueChange = { date.value = it },
                    label = { Text("Date") },
                    isError = !isDateValid
                )
                OutlinedTextField(
                    value = time.value,
                    onValueChange = { time.value = it },
                    label = { Text("Time") },
                    isError = !isTimeValid
                )
                Button(
                    onClick = {
                        viewModel.createReminder.onEach { result ->
                            result.handleResult(
                                onSuccess = {
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar("Reminder added succesfully")
                                        navController.popBackStack()
                                    }

                                },
                                onError = {
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar(it ?: "")
                                        navController.popBackStack()
                                    }
                                }
                            )
                        }.launchIn(viewModel.viewModelScope)

                        viewModel.createReminder(
                            name.value,
                            description.value,
                            type.value,
                            date.value,
                            time.value
                        )
                    },
                    enabled = isFormValid
                ) {
                    Text("Add Reminder")
                }
            }
        }
    )

}