# Use Case 4

## 1. Title : Update Existing Task

## 2. Actors
- **Primary Actor(s):** The User
- **Secondary Actor(s):** None

## 3. Preconditions
- User has an account
- User in logged in
- Task Chosen for Update exists

## 4. Postconditions
- Task Attribute changes are updated in database
- Task reminder changes are updated in database
- Updated Task is visible for User
- Updated Task is Still updateable
- Updated Task is Recalculated in report

## 5. Main Success Scenario
- 1 - User navigates to the Update Task Button
- 2 - User re-sets Task Attributes
- 3 - User re-sets Task reminder
- 4 - User clickes The Confirmation button
- 5 - task creation time is re-set To the time of Update
- 6 - A completion messege is shown to user

## 6. Extensions

- **Extension 1:**
    - 1 - User navigates to the Update Task Button
    - 2 - User **Doesn not make Changes** in Task Attributes
    - 3 - User **Doesn not make Changes** in reminder
    - 4 - User clickes The Confirmation button
    - 5 - A Note messege is sent to the user Than no Changes have Been made
    - 6 - User Confirms To abandon Update Page

