# Use Case: Display Report Per TimeFrame

## Actors:
- **User**

## Preconditions:
1. The user is already logged in.
2. The user has completed multiple tasks that can be reported on.

## Main Flow:
1. The user selects “view progress” based on a valid time frame (week, month, year).
2. The system retrieves data for the selected time frame and generates a progress report.
3. The system displays a report with the user’s progress.

## Alternative Flow:
- **1.a.** If the user enters a timeframe that is not already reached:
    1. The system displays an error message:  
       _“Unable to generate the report. Invalid time frame, please try again.”_

## Postconditions:
1. The user has viewed the report successfully based on the chosen time frame.
