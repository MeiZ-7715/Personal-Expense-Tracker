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
```

---
Explanation:

States: Draft (unsaved), Saved (persisted), Edited (modified but not saved), Deleted (removed).

Events: save, edit, delete. Guard: amount must be > 0 ZAR.

Maps to: FR-03 (add expense), FR-04 (edit/delete).

```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Saved : user saves expense
    Saved --> Edited : user modifies
    Edited --> Saved : save changes
    Saved --> Deleted : user deletes
    Deleted --> [*]
```

---

