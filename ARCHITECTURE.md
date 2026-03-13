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

  UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
