# C4 Architecture for Personal Expense Tracker

This document outlines the architecture of the Personal Expense Tracker system using the C4 model.

## Level 1: System Context Diagram
This diagram shows the big picture: our system and the people it interacts with.

```mermaid
C4Context
  title System Context diagram for Personal Expense Tracker

  Person(user, "User", "A person who wants to track their daily expenses and understand spending habits.")

  System(expenseTracker, "Personal Expense Tracker", "Allows users to record expenses, categorize them, and view monthly reports.")

  Rel(user, expenseTracker, "Adds expenses, views reports, manages categories")
...
## Container Diagram
This diagram zooms into the Personal Expense Tracker System to show the high‑level technical building blocks.

```mermaid
C4Container
  title Container diagram for the Personal Expense Tracker

  Person(user, "User", "A person who wants to track expenses.")

  Container_Boundary(expenseTracker, "Personal Expense Tracker") {
    Container(web_app, "Web Application", "React / Angular", "Provides the user interface for managing expenses and viewing reports.")
    Container(api, "Backend API", "Java Spring Boot", "Handles business logic: expense management, categories, reports, and user data.")
    ContainerDb(db, "Database", "MySQL / H2", "Stores users, expenses, categories, and transaction history.")
  }

  Rel(user, web_app, "Uses", "HTTPS")
  Rel(web_app, api, "Makes API calls to", "JSON/HTTPS")
  Rel(api, db, "Reads/Writes to", "JDBC/SQL")
...
Component Diagram (Backend API)
This diagram zooms into the Backend API container to show the major structural building blocks.

```mermaid
C4Component
  title Component diagram for the Backend API Container

  Container_Boundary(api, "Backend API") {
    Component(expense_controller, "Expense Controller", "REST Endpoint", "Handles requests to add, update, delete, and retrieve expenses.")
    Component(category_controller, "Category Controller", "REST Endpoint", "Manages expense categories (create, list, update).")
    Component(report_controller, "Report Controller", "REST Endpoint", "Generates monthly spending reports and summaries.")
    Component(auth_middleware, "Auth Middleware", "Middleware", "Verifies user identity (JWT) for protected endpoints.")

    Component(expense_service, "Expense Service", "Business Logic", "Contains rules for expense validation, calculations, and aggregation.")
    Component(category_service, "Category Service", "Business Logic", "Handles category operations and default categories.")
    Component(report_service, "Report Service", "Business Logic", "Aggregates expense data for reports.")

    Component(expense_repo, "Expense Repository", "Data Access", "Abstracts database operations for expenses.")
    Component(category_repo, "Category Repository", "Data Access", "Abstracts database operations for categories.")
    Component(user_repo, "User Repository", "Data Access", "Abstracts database operations for users.")
  }

  ContainerDb(db, "Database", "MySQL / H2", "Stores all system data.")
  Container(web_app, "Web Application", "External Container", "Makes API calls.")

  Rel(web_app, expense_controller, "add/get/delete expenses", "JSON/HTTPS")
  Rel(web_app, category_controller, "manage categories", "JSON/HTTPS")
  Rel(web_app, report_controller, "request reports", "JSON/HTTPS")

  Rel(expense_controller, expense_service, "Uses")
  Rel(category_controller, category_service, "Uses")
  Rel(report_controller, report_service, "Uses")

  Rel(expense_service, expense_repo, "Uses")
  Rel(category_service, category_repo, "Uses")
  Rel(report_service, expense_repo, "Uses")
  Rel(report_service, category_repo, "Uses")

  Rel(expense_repo, db, "Reads/Writes", "SQL")
  Rel(category_repo, db, "Reads/Writes", "SQL")
  Rel(user_repo, db, "Reads/Writes", "SQL")

  Rel(expense_controller, auth_middleware, "Protected by")
  Rel(category_controller, auth_middleware, "Protected by")
  Rel(report_controller, auth_middleware, "Protected by")

  UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
  ...

Level 4: Code Diagram (Class Diagram)
This diagram shows the structure of the main data classes and their relationships.

```mermaid
classDiagram
class Expense {
  -Long id
  -Double amount
  -String description
  -LocalDate date
  -Category category
  -User user
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

  UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
...
