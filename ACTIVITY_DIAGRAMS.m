# Activity Diagrams – Personal Expense Tracker

**Project:** Personal Expense Tracker (South African Rand – ZAR)  
**Based on:** Assignments 4 (requirements), 5 (use cases), 6 (user stories)  

This document presents 8 activity workflows using UML sequence diagram notation (swimlanes for User and System). Each diagram is followed by a detailed step‑by‑step explanation and traceability to functional requirements/user stories.

---

## 1. User Registration Workflow

```mermaid
sequenceDiagram
    participant User
    participant System
    User->>User: Enter email & password
    User->>System: Submit
    System->>System: Validate email format & password strength
    alt valid
        System->>System: Create account & send verification email
        System->>User: Show success & auto-login
    else invalid
        System->>User: Display error message
        User->>User: Re-enter details
    end
