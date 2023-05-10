package com.example.challengekatas2.data.mapper

import com.example.challengekatas2.data.entity.ReminderEntity
import com.example.challengekatas2.domain.Reminder

object ReminderMapper {
    fun mapToReminderDomain(entity: ReminderEntity): Reminder {
        return Reminder(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            date = entity.date,
            time = entity.time
        )
    }

    fun mapToReminderEntity(reminder: Reminder): ReminderEntity {
        return ReminderEntity(
            id = reminder.id,
            title = reminder.title,
            description = reminder.description,
            date = reminder.date,
            time = reminder.time
        )
    }

    fun mapToReminderDomainList(entities: List<ReminderEntity>): List<Reminder> {
        return entities.map{ entity ->
            Reminder(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                date = entity.date,
                time = entity.time
            )
        }
    }

    fun mapToReminderEntityList(reminders: List<Reminder>): List<ReminderEntity> {
        return reminders.map{ reminder ->
            ReminderEntity(
                id = reminder.id,
                title = reminder.title,
                description = reminder.description,
                date = reminder.date,
                time = reminder.time
            )
        }
    }
}