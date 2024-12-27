# Use Case: Search Tasks

## Actors:
- **User**

## Preconditions:
1. The user is already logged in.
2. The user has already initiated multiple tasks.

## Main Flow:
1. The user clicks on the search bar.
2. The user enters a valid name of the task he/she is searching for.
3. The system searches for tasks that match the entered name.
4. The system displays the matching tasks.
5. The user clicks on the desired task.

## Alternative Flow:
- **2.a.** The user has entered a non-existent task name:
    1. The system searches for tasks that match the entered name.
    2. The system does not find a match.
    3. An error message appears to the user:  
       _“There is no task named like this. Please try entering a valid name.”_

## Postconditions:
1. The user has successfully found and selected the task they were searching for.
