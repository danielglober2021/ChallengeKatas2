package com.example.challengekatas2.domain

data class Reminder(
    val id: Int,
    val title: String,
    val description: String,
    val date: Long,
    val time: Long
)