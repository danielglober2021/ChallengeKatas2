package com.example.challengekatas2.ui.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.challengekatas2.ui.reminder.navigation.NavigationHost
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