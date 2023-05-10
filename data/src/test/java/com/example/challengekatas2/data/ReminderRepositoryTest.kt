package com.example.challengekatas2.data

import com.example.challengekatas2.data.entity.ReminderEntity
import com.example.challengekatas2.data.local.dao.ReminderDao
import com.example.challengekatas2.data.local.repository.ReminderLocalDataSource
import com.example.challengekatas2.data.mapper.ReminderMapper
import com.example.challengekatas2.data.repository.ReminderRepository
import com.example.challengekatas2.domain.Reminder
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

class ReminderRepositoryTest {

    // Use MockK's extension functions to mock dependencies
    private val reminderDao = mockk<ReminderDao>()
    // private val mapper = mockk<ReminderMapper>()

    private val reminderLocalDataSource = ReminderLocalDataSource(reminderDao)

    private val repository = ReminderRepository(reminderLocalDataSource)

    private val reminderEntities = listOf(
        ReminderEntity(
            id = 1,
            title = "Notification 1",
            description = "Description of notification 1",
            date = 1234567890,
            time = 9876543210
        ),
        ReminderEntity(
            id = 2,
            title = "Notification 2",
            description = "Description of notification 2",
            date = 1234566666,
            time = 9876543333
        )
    )
    private val reminders = listOf(
        Reminder(
            id = 1,
            title = "Notification 1",
            description = "Description of notification 1",
            date = 1234567890,
            time = 9876543210),
        Reminder(
            id = 2,
            title = "Notification 2",
            description = "Description of notification 2",
            date = 1234566666,
            time = 9876543333)
    )

    @Before
    fun setUp(){
        every { reminderDao.getReminders() } returns flowOf(reminderEntities)

        // every { ReminderMapper.mapToReminderDomainList(reminderEntities) } returns reminders
        // every { ReminderMapper.mapToReminderEntityList(reminders) } returns reminderEntities
    }

    @Test
    fun `should return reminders`() = runBlocking {

        // When
        val result = repository.getReminders().firstOrNull()

        // Then
        assertNotNull(result)
        assertEquals(reminderEntities, result)
    }

    // More tests...
}