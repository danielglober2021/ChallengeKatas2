package com.example.challengekatas2.ui.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challengekatas2.ui.reminder.navigation.NavigationHost
import com.example.challengekatas2.ui.reminder.screens.AddReminderScreen
import com.example.challengekatas2.ui.reminder.screens.ReminderDetailScreen
import com.example.challengekatas2.ui.reminder.screens.ReminderListScreen
import com.example.challengekatas2.ui.theme.ChallengeKatas2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReminderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}