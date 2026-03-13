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
