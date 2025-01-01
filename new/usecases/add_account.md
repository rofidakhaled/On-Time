# Use Case: Add Account

## Actors:
- **User**

## Preconditions:
1. The system is functional.
2. The user does not have an existing account.

## Main Flow:
1. The user clicks on "Add an Account."
2. The system displays the account creation form.
3. The user enters a username.
4. The user enters a password.
5. The user adds an email address.
6. The user submits the form.
7. The system validates the inputs.
8. The system displays a message to the user:  
   _“The account is created successfully”_  
   and redirects them to the main page.

## Alternative Flow:
- **8.a.** If the system detects errors (e.g., invalid username, password, or email):
    1. It displays an error message:  
       _“Invalid username/password. Please try again.”_
    2. The user is redirected back to the account creation form with invalid fields highlighted.

## Postconditions:
1. The user has successfully created a new account and is redirected to the main page.
2. The new account details are saved in the system's database.
