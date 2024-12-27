# Use Case 5

## 1. Title :  Remove Existing Task

## 2. Actors
- **Primary Actor(s):** The User
- **Secondary Actor(s):** None

## 3. Preconditions
- User has an account
- User is logged in
- Task Chosen for removal exists

## 4. Postconditions
- Task is removed from database
- Task reminder removed from database
- Task is not visible for User
- Task is not retrievable
- Task removal is re-calculated in report

## 5. Main Success Scenario
- 1 - User navigates to the remove Task button
- 2 - A warning messege is shown to user
- 3 - User confirms intent to remove Task
- 4 - A completion messege is shown to user

## 6. Extensions

- **Extension 1:**
    - 1 - User navigates to the remove Task button
    - 2 - A warning messege is shown to user
    - 3 - User **does not** confirm intent to remove Task
    - 4 - User confirms to abandon Task Removal 
