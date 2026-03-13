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

## Architectural Diagrams (C4 Model)

### 1. Context Diagram (Level 1)
**What it shows:** The big picture – the user and the system they interact with.

```mermaid
flowchart TD
    User["User<br/>A person who wants to track expenses"]
    System["Personal Expense Tracker<br/>Allows users to record and view expenses"]

    User -->|Uses| System

```mermaid
flowchart TD
    User["User"]

    subgraph Personal Expense Tracker
        WebApp["Web Application<br/>React / Angular<br/>Provides user interface"]
        API["REST API<br/>Java Spring Boot<br/>Handles business logic"]
        Database[("Database<br/>MySQL / H2<br/>Stores data")]
    end

    User -->|Uses| WebApp
    WebApp -->|Calls (JSON/HTTPS)| API
    API -->|Reads/Writes (JDBC)| Database
    ```mermaid
    flowchart TD
    subgraph REST_API["REST API Container"]
        direction TB
        ExpenseController["ExpenseController"]
        CategoryController["CategoryController"]
        ReportController["ReportController"]

        ExpenseService["ExpenseService"]
        CategoryService["CategoryService"]
        ReportService["ReportService"]

        ExpenseRepo["ExpenseRepository"]
        CategoryRepo["CategoryRepository"]
        UserRepo["UserRepository"]
    end

    ExpenseController --> ExpenseService
    CategoryController --> CategoryService
    ReportController --> ReportService

    ExpenseService --> ExpenseRepo
    CategoryService --> CategoryRepo
    ReportService --> ExpenseRepo
    ReportService --> CategoryRepo
     ```mermaid
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
 
