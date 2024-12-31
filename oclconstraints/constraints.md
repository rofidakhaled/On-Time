# User Context
```ocl
inv: self.TaskManager->size() = 1   (every user has only one task manager)
inv: self.Report->size() >= 0      (user can create zero or more reports)
```
# TaskManager Context
```ocl
inv: self.TODO->size() > 0        (task manager manages at least one to do)
inv: self.TODO->forAll(task | task.status <> null)  (every to do has to have status)
```
# ToDo Context
```ocl
inv: self.status <> null         (there must be a status, value cannot be null)
inv: self.creationTime <> null    (creation time cannot be null)
inv: self.Reminder->size() >= 0   (to dos can have zero or more reminders)
```
# Reminder Context
```ocl
inv: self.reminderDateTime <> null    (datetime cannot be null)
inv: self.Notification->size() >= 0   (zero or more notifications can be triggered by reminder)
```
# Notification Context
```ocl
inv: self.sentDateTime <> null   (notifications must have a datetime to be triggered at)
```
# Report Context
```ocl
inv: self.timeFrame <> null              (time frame cannot be null)
inv: self.TaskManager->size() > 0        (report can only be generated if task manager has more than zero tasks)
```