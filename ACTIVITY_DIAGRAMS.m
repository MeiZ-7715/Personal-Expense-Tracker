# Activity Diagrams – Personal Expense Tracker

---

## 1. User Registration Workflow

```mermaid
flowchart TD
    A([Start]) --> B[Enter email and password]
    B --> C[Submit to system]
    C --> D[Validate input]
    D --> E{Valid?}
    E -- Yes --> F[Create account]
    F --> G[Show success message]
    G --> H([End])
    E -- No --> I[Show error message]
    I --> B
```

**Explanation:** User registers → system validates → success or retry.
**Maps to:** FR-01

---

## 2. Add Expense

```mermaid
flowchart TD
    A([Start]) --> B[Enter expense details]
    B --> C[Save expense]
    C --> D[Validate amount]
    D --> E{Valid?}
    E -- Yes --> F[Save expense to database]
    F --> G[Show success message]
    G --> H([End])
    E -- No --> I[Show error message]
    I --> B
```

**Explanation:** Expense saved if valid amount.
**Maps to:** FR-03

---

## 3. Set Budget

```mermaid
flowchart TD
    A([Start]) --> B[Enter budget amount]
    B --> C[Submit to system]
    C --> D[Validate budget]
    D --> E{Valid?}
    E -- Yes --> F[Save budget]
    F --> G[Show confirmation]
    G --> H([End])
    E -- No --> I[Show error message]
    I --> B
```

**Explanation:** Budget saved if valid.
**Maps to:** FR-07

---

## 4. Budget Alert

```mermaid
flowchart TD
    A([Start]) --> B[Monitor spending]
    B --> C[Check total vs limit]
    C --> D{Limit reached?}
    D -- Yes --> E[Send alert to user]
    E --> F[User dismisses alert]
    F --> B
    D -- No --> B
```

**Explanation:** System monitors spending and alerts the user.
**Maps to:** FR-08

---

## 5. Export CSV

```mermaid
flowchart TD
    A([Start]) --> B[Request export]
    B --> C[Queue export job]
    C --> D{ }
    D --> E[Generate CSV file]
    D --> F[Log export request]
    E --> G{ }
    F --> G
    G --> H[Send download to user]
    H --> I([End])
```

**Explanation:** Export runs with parallel processing.
**Maps to:** FR-09

---

## 6. Edit Expense

```mermaid
flowchart TD
    A([Start]) --> B[Edit expense details]
    B --> C[Save changes]
    C --> D[Validate changes]
    D --> E{Valid?}
    E -- Yes --> F[Update expense in database]
    F --> G[Show success message]
    G --> H([End])
    E -- No --> I[Show error message]
    I --> B
```

**Explanation:** Updates only if valid.
**Maps to:** FR-04

---

## 7. Delete Expense

```mermaid
flowchart TD
    A([Start]) --> B[Select expense to delete]
    B --> C[Show confirmation dialog]
    C --> D{Confirmed?}
    D -- Yes --> E[Delete expense]
    E --> F[Show deletion confirmed]
    F --> G([End])
    D -- No --> H[Cancel - no changes made]
    H --> G
```

**Explanation:** Requires confirmation before delete.
**Maps to:** FR-04

---

## 8. Monthly Summary

```mermaid
flowchart TD
    A([Start]) --> B[Request monthly summary]
    B --> C[Process expense data]
    C --> D[Generate summary chart]
    D --> E[Display results to user]
    E --> F([End])
```

**Explanation:** System processes data and displays the monthly summary.
**Maps to:** FR-06


