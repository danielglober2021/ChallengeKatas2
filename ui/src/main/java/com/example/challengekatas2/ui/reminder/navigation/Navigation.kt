package com.example.challengekatas2.ui.reminder.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challengekatas2.ui.reminder.screens.AddReminderScreen
import com.example.challengekatas2.ui.reminder.screens.ReminderDetailScreen
import com.example.challengekatas2.ui.reminder.screens.ReminderListScreen
import com.example.challengekatas2.ui.theme.ChallengeKatas2Theme

@Composable
fun NavigationHost(){
    val navController = rememberNavController()
    ChallengeKatas2Theme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed" ) {
                composable(route = "feed") {
                    ReminderListScreen(navController = navController)
                }
                composable(route = "detail/{reminderId}") { backstackEntry ->
                    val reminderIdString = backstackEntry.arguments?.getString("reminderId") ?: "0"
                    val reminderId = reminderIdString.toLong()
                    ReminderDetailScreen(navController = navController, reminderId = reminderId)
                }
                composable(route = "add") { backstackEntry ->
                    AddReminderScreen(navController = navController)
                }
            }
        }
    }
}