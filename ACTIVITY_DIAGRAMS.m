# Activity Diagrams – Personal Expense Tracker

All amounts in ZAR.

---

## 1. User Registration Workflow
```mermaid
flowchart TD
    subgraph User
        A[Enter email & password]
        B[Submit details]
    end

    subgraph System
        C[Validate email & password]
        D{Valid?}
        E[Create account]
        F[Send verification email]
        G[Show success & auto-login]
        H[Show error message]
    end

    A --> B
    B --> C
    C --> D
    D -->|Yes| E
    E --> F
    F --> G
    D -->|No| H
    H --> A
```

---

## 2. Add Expense
```mermaid
flowchart TD
    subgraph User
        A[Enter expense details]
        B[Click Save]
    end

    subgraph System
        C[Validate amount > 0]
        D{Valid?}
        E[Save expense]
        F[Update totals]
        G[Check budget alert]
        H[Show success]
        I[Show error]
    end

    A --> B
    B --> C
    C --> D
    D -->|Yes| E
    E --> F
    F --> G
    G --> H
    D -->|No| I
```

---

## 3. Set Monthly Budget
```mermaid
flowchart TD
    subgraph User
        A[Enter budget amount]
        B[Submit]
    end

    subgraph System
        C[Validate amount]
        D{Valid?}
        E[Save budget]
        F[Show confirmation]
        G[Show error]
    end

    A --> B
    B --> C
    C --> D
    D -->|Yes| E
    E --> F
    D -->|No| G
```

---

## 4. Budget Alert Trigger
```mermaid
flowchart TD
    subgraph System
        A[Monitor spending]
        B{Spending >= 80%?}
        C[Create alert]
        D[Send notification]
        E[Continue monitoring]
    end

    subgraph User
        F[View alert]
        G[Dismiss alert]
    end

    A --> B
    B -->|Yes| C
    C --> D
    D --> F
    F --> G
    B -->|No| E
    E --> A
```

---

## 5. Export CSV
```mermaid
flowchart TD
    subgraph User
        A[Request export]
    end

    subgraph System
        B[Queue job]
        C[Generate CSV]
        D[Log request]
        E[Provide download]
    end

    A --> B
    B --> C
    B --> D
    C --> E
    D --> E
```

---

## 6. Edit Expense
```mermaid
flowchart TD
    subgraph User
        A[Select expense]
        B[Modify details]
        C[Save changes]
    end

    subgraph System
        D[Validate amount]
        E{Valid?}
        F[Update expense]
        G[Recalculate totals]
        H[Show success]
        I[Show error]
    end

    A --> B
    B --> C
    C --> D
    D --> E
    E -->|Yes| F
    F --> G
    G --> H
    E -->|No| I
```

---

## 7. Delete Expense
```mermaid
flowchart TD
    subgraph User
        A[Select expense]
        B[Click delete]
    end

    subgraph System
        C[Ask confirmation]
        D{Confirmed?}
        E[Delete expense]
        F[Update totals]
        G[Show confirmation]
        H[Cancel action]
    end

    A --> B
    B --> C
    C --> D
    D -->|Yes| E
    E --> F
    F --> G
    D -->|No| H
```

---

## 8. View Monthly Summary
```mermaid
flowchart TD
    subgraph User
        A[Select month]
        B[Request summary]
    end

    subgraph System
        C[Aggregate expenses]
        D[Generate chart]
        E[Display results]
    end

    A --> B
    B --> C
    C --> D
    D --> E
```
