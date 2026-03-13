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
C4Context
title System Context diagram for Personal Expense Tracker

Person(user, "User", "A person who wants to track their expenses")
System(expenseTracker, "Personal Expense Tracker", "Allows users to record and view expenses")

Rel(user, expenseTracker, "Uses")
