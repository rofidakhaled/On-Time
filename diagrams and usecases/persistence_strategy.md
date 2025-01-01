# Persistence Strategy

## Database Overview
The On-Time application uses:
- **Database**: H2 (file-based)
- **ORM**: Spring Data JPA with Hibernate
- **Mode**: File-based persistence (not in-memory)

## Database Configuration
```properties
# Database Connection
spring.datasource.url=jdbc:h2:file:C:/Users/safia/test
spring.datasource.username=sa
spring.datasource.password=password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
```

## Entity Storage Strategy

### User
- Stored in `app_user` table
- UUID as primary key
- Has one TaskManager
- Can have many Reports
- Email must be unique

### TaskManager
- Auto-generated ID
- Linked to one User
- Contains multiple ToDo items
- Foreign key to User table

### ToDo
- Auto-generated ID
- Belongs to one TaskManager
- Can have multiple Reminders
- Status tracked ('pending' or 'completed')
- Creation time and due date stored

### Reminder
- Auto-generated ID
- Linked to one ToDo
- Stores reminder date/time
- Optional recurrence pattern
- Can trigger multiple notifications

### Notification
- Auto-generated ID
- Linked to one Reminder
- Stores sent date/time
- Tracks notification status

### Report
- Auto-generated ID
- Linked to one User
- Stores report type and time frame
- Generation time recorded

## Data Access
- Each entity has a Repository interface
- Basic CRUD operations provided by Spring Data
- Custom queries for specific operations
- Transactions managed by Spring

## Security
- failed to implement
- Passwords stored with encryption
- Database access restricted by username/password
- File-based storage for data persistence
