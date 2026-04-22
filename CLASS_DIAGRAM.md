# Class Diagram – Personal Expense Tracker

**UML Class Diagram** in Mermaid.js.  
It shows the 6 core entities, their attributes, methods, relationships, and multiplicities.

## Mermaid Class Diagram

```mermaid
classDiagram
    class User {
        -String userId
        -String email
        -String passwordHash
        -Boolean isVerified
        -Date createdAt
        +register()
        +login()
        +updateProfile()
        +deleteAccount()
    }

    class Expense {
        -String expenseId
        -Double amount
        -String description
        -LocalDate date
        -String categoryId
        -String userId
        -Boolean isShared
        +save()
        +edit()
        +delete()
    }

    class Category {
        -String categoryId
        -String name
        -String type
        -Boolean isActive
        +createCustom()
        +deactivate()
        +delete()
    }

    class Budget {
        -String budgetId
        -String categoryId
        -String userId
        -YearMonth month
        -Double amountLimit
        -Double spentAmount
        +setBudget()
        +updateSpent()
        +checkThreshold()
    }

    class Alert {
        -String alertId
        -String userId
        -String budgetId
        -String message
        -Date triggeredAt
        -String status
        +trigger()
        +dismiss()
        +expire()
    }

    class SharedExpense {
        -String shareId
        -String expenseId
        -String ownerId
        -String sharedWithId
        -String status
        +invite()
        +accept()
        +reject()
    }

    User "1" --> "0..*" Expense : owns
    User "1" --> "0..*" Budget : sets
    User "1" --> "0..*" Alert : receives
    User "1" --> "0..*" SharedExpense : as_owner
    User "1" --> "0..*" SharedExpense : as_sharedWith

    Category "1" --> "0..*" Expense : categorises
    Category "1" --> "0..*" Budget : has_limit

    Budget "1" --> "0..*" Alert : triggers
    Expense "1" --> "0..1" SharedExpense : shared
