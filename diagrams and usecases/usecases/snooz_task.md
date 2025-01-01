# Use Case: Snooze Reminder

## Actors:
- **User**

## Preconditions:
1. The user is already logged in.
2. A reminder has already been set.
3. A reminder has been received.

## Main Flow:
1. The user receives the reminder details.
2. The user selects the "Snooze" option from the reminder notification.
3. The user selects the snooze duration.
4. The system updates the snooze time.
5. A message appears to the user:  
   _“A new reminder has been set.”_

## Alternative Flow:
- **3.a.** If the user selects an invalid snooze duration:
    1. The system sends an error message:  
       _“Invalid duration, please try again.”_

## Postconditions:
1. The reminder is successfully snoozed.
2. The reminder will trigger again after the newly specified time.
