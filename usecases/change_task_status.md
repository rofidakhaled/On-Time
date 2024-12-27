# Use Case 6

## 1. Title :  Change Task Status

## 2. Actors
- **Primary Actor(s):** The User
- **Secondary Actor(s):** None

## 3. Preconditions
- User has an account
- User in logged in
- Task Chosen for Status Change exists

## 4. Postconditions
- Task Status change is updated in database
- Updated Task Status visiblity is based on Updated Status Value
- Updated Task Status is Still updateable
- Updated Task Status is Recalculated in report

## 5. Main Success Scenario
- 1 - User navigates to the Task Status Button
- 2 - User re-sets Task Status from "Pending" to "In Progress"
- 3 - User clickes The Confirmation button
  Update
- 4 - A completion messege is shown to user

## 6. Extensions

- **Extension 1:**
    - 1 - User navigates to the Task Status Button
    - 2 - User re-sets Task Status from **"In progress"** to **"Done"**
    - 3 - User clickes The Confirmation button
      Update
    - 4 - Task is moved From User Visiblity and is added To the done Tasks list in the database
    - 5 - A completion messege is shown to user

- **Extension 1:**
    - 1 - User navigates to the Task Status Button
    - 2 - User re-sets Task Status from **"In progress"** to **"In progress"**
    - 3 - User clickes The Confirmation button
      Update
    - 5 - A completion messege is shown to user
