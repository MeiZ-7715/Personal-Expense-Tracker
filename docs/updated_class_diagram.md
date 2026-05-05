# Updated Class Diagram with Repository Layer

```mermaid
classDiagram
    class Repository<T, ID> {
        <<interface>>
        +save(T entity)
        +findById(ID id) Optional~T~
        +findAll() List~T~
        +delete(ID id)
    }

    class UserRepository {
        <<interface>>
        +findByEmail(String email) Optional~User~
    }

    class InMemoryUserRepository {
        -Map~String,User~ storage
        +save(User)
        +findById(String) Optional~User~
        +findByEmail(String) Optional~User~
    }

    class ExpenseRepository {
        <<interface>>
        +findByUserId(String) List~Expense~
        +findByDateRange(LocalDate, LocalDate) List~Expense~
    }

    class InMemoryExpenseRepository {
        -Map~String,Expense~ storage
        +save(Expense)
        +findByUserId(String) List~Expense~
    }

    Repository <|-- UserRepository
    Repository <|-- ExpenseRepository
    UserRepository <|.. InMemoryUserRepository
    ExpenseRepository <|.. InMemoryExpenseRepository
