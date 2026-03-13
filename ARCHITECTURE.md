# Personal Expense Tracker – Architecture Documentation

## Project Title
Personal Expense Tracker

## Domain
Personal Finance

## Problem Statement
(See [SPECIFICATION.md](SPECIFICATION.md) for details.)

## Individual Scope
As described in the specification, the system is simple enough to be built by one person.

---

## C4 Architectural Diagrams

### 1. Context Diagram

```mermaid
C4Container
title Container diagram for Personal Expense Tracker

Person(user, "User", "A person who wants to track expenses")

System_Boundary(tracker, "Personal Expense Tracker") {
    Container(webApp, "Web Application", "React / Angular", "Provides the user interface")
    Container(api, "REST API", "Java Spring Boot", "Handles business logic and data access")
    ContainerDb(db, "Database", "MySQL / H2", "Stores users, expenses, and categories")
}

Rel(user, webApp, "Uses", "HTTPS")
Rel(webApp, api, "Calls", "JSON/HTTPS")
Rel(api, db, "Reads/Writes", "JDBC")

C4Component
title Component diagram for REST API Container

Container(api, "REST API", "Java Spring Boot", "Handles business logic and data access")

Component(expenseController, "ExpenseController", "REST endpoints for expenses")
Component(categoryController, "CategoryController", "REST endpoints for categories")
Component(reportController, "ReportController", "REST endpoint for monthly reports")

Component(expenseService, "ExpenseService", "Business logic for expenses")
Component(categoryService, "CategoryService", "Business logic for categories")
Component(reportService, "ReportService", "Generates reports")

Component(expenseRepo, "ExpenseRepository", "Database access for expenses")
Component(categoryRepo, "CategoryRepository", "Database access for categories")
Component(userRepo, "UserRepository", "Database access for users")

Rel(expenseController, expenseService, "Uses")
Rel(categoryController, categoryService, "Uses")
Rel(reportController, reportService, "Uses")
Rel(expenseService, expenseRepo, "Uses")
Rel(categoryService, categoryRepo, "Uses")
Rel(reportService, expenseRepo, "Uses")
Rel(reportService, categoryRepo, "Uses")

classDiagram
class Expense {
  -Long id
  -Double amount
  -String description
  -LocalDate date
  -Category category
  +getters/setters()
}

class Category {
  -Long id
  -String name
  -String description
  +getters/setters()
}

class User {
  -Long id
  -String username
  -String password
  +getters/setters()
}

Expense "many" --> "1" Category : belongs to
Expense "many" --> "1" User : owned by
