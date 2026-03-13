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
