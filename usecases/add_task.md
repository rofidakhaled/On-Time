# Use Case 1

## 1. Title : Add New Task

## 2. Actors
- **Primary Actor(s):** The User
- **Secondary Actor(s):** None

## 3. Preconditions
- User has an account
- User in logged in

## 4. Postconditions
- Task is added to database
- Task reminder is added to database
- Task is visible for User
- Task is updateable
- Task is calculated in report

## 5. Main Success Scenario
- 1 - User navigates to the Add Task button/ page
- 2 - User sets Task Attributes
- 3 - User sets Task reminder
- 4 - User clickes The Confirmation button
- 5 - task creation time is set
- 6 - A completion messege is shown to user

## 6. Extensions

- **Extension 1:**
    - 1 - User navigates to the Add Task button/ page
    - 2 - User sets Task Attributes
    - 3 - User Does **not** set Task reminder
    - 4 - User clickes The Confirmation button
    - 5 - Task reminder is set as None
    - 6 - task creation time is set
- **Extension 2:**
    - 1 - User navigates to the Add Task button/ page
    - 2 - User sets Task Attributes
    - 3 - User sets Task reminder
    - 4 - User  does **not** click The Confirmation button
    - 5 - User attempts to leave the page
    - 6 - A warning messege is showen to User
    - 7 - User Confirms intention to abandon Draft
    - 8 - Task Draft is cleared without being set
