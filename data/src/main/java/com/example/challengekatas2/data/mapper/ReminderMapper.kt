package com.example.challengekatas2.data.mapper

import com.example.challengekatas2.data.entity.ReminderEntity
import com.example.challengekatas2.domain.Reminder

class ReminderMapper {
    fun map(entity: ReminderEntity): Reminder {
        return Reminder(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            date = entity.date,
            time = entity.time
        )
    }

    fun map(reminder: Reminder): ReminderEntity {
        return ReminderEntity(
            id = reminder.id,
            title = reminder.title,
            description = reminder.description,
            date = reminder.date,
            time = reminder.time
        )
    }
}