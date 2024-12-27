# Use Case: Receive Reminder

## Actors:
- **User**

## Preconditions:
1. The user is logged in.
2. The user has already set a reminder.

## Main Flow:
1. At the specific time chosen by the user, the system sends a reminder.
2. The user receives the reminder and views the task details.
3. The user disables the reminder.

## Alternative Flow:
- **2.a.** If the user does not receive the reminder due to an error (e.g., no internet connection):
    1. The system sends an error message to the user:  
       _“Reminder has been disabled due to an issue.”_

## Postconditions:
1. The user has been reminded of the task.
2. The reminder is either disabled or snoozed.
