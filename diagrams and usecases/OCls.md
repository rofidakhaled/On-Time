# User Context
```ocl
context User
-- Each user must have exactly one task manager
inv uniqueTaskManager: self.TaskManager->size() = 1

-- User can have zero or more reports
inv validReports: self.Report->size() >= 0

-- User must have valid credentials
inv validEmail: self.email <> null and self.email.size() > 0
inv validName: self.name <> null and self.name.size() > 0
inv validPassword: self.password <> null and self.password.size() >= 8
```

# TaskManager Context
```ocl
context TaskManager
-- Task manager must manage at least one todo
inv hasTodos: self.TODO->size() > 0

-- Every todo must have a status
inv validTodoStatus: self.TODO->forAll(task | task.status <> null)

-- Tasks must have unique IDs
inv uniqueTaskIds: self.TODO->forAll(t1, t2 | t1 <> t2 implies t1.id <> t2.id)

-- Tasks must be associated with the user
inv validOwner: self.user <> null
```

# ToDo Context
```ocl
context ToDo
-- Basic validation constraints
inv validStatus: self.status <> null
inv validCreationTime: self.creationTime <> null
inv validReminders: self.Reminder->size() >= 0

-- Status must be either 'pending' or 'completed'
inv validStatusValues: Set{'pending', 'completed'}->includes(self.status)

-- Creation time must be in the past or present
inv validCreationTimeRange: self.creationTime <= System.currentTime()

-- Title constraints
inv validTitle: self.title <> null and self.title.size() > 0
```

# Reminder Context
```ocl
context Reminder
-- Basic validation constraints
inv validDateTime: self.reminderDateTime <> null
inv validNotifications: self.Notification->size() >= 0

-- Reminder time must be in the future when created
inv futureReminder: self.reminderDateTime > System.currentTime()

-- Name validation
inv validName: self.name <> null and self.name.size() > 0

-- Recurrence validation (if present)
inv validRecurrence: self.recurrence <> null implies 
    Set{'DAILY', 'WEEKLY', 'MONTHLY', 'NONE'}->includes(self.recurrence)

-- Recurrence timestamps must be after reminder date time
inv validRecurrenceTimestamps: self.recurrenceTimeStamps->forAll(t | t > self.reminderDateTime)
```

# Notification Context
```ocl
context Notification
-- Basic validation constraints
inv validSentDateTime: self.sentDateTime <> null

-- Notification must be associated with a reminder
inv validReminder: self.reminder <> null

-- Sent time must be after reminder creation
inv validSentTime: self.sentDateTime >= self.reminder.reminderDateTime
```

# Report Context
```ocl
context Report
-- Basic validation constraints
inv validTimeFrame: self.timeFrame <> null
inv validTaskManager: self.TaskManager->size() > 0

-- Time frame must be a valid range
inv validTimeRange: self.timeFrame.startDate < self.timeFrame.endDate

-- Report type must be valid
inv validReportType: Set{'TaskCompletion', 'TaskPending', 'Reminders'}->includes(self.type)

-- Generated time must be present
inv validGeneratedTime: self.generatedTime <> null
inv validGeneratedTimeRange: self.generatedTime >= self.timeFrame.startDate