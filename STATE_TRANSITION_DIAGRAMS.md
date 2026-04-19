# State Transition Diagrams – Personal Expense Tracker

This document describes the lifecycle of 8 critical objects in the system using UML state transition diagrams. All monetary values are in South African Rand (ZAR).

## 1. User Account

```mermaid
stateDiagram-v2
    [*] --> Inactive
    Inactive --> Active : verify email
    Active --> Suspended : too many failed logins
    Suspended --> Active : admin reactivates
    Active --> Deleted : user deletes account
    Deleted --> [*]

