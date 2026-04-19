# Activity Diagrams – Personal Expense Tracker

---

## 1. User Registration Workflow
```mermaid
flowchart TD
    subgraph User_Lane
        A[Enter email and password]
        B[Submit details]
    end

    subgraph System_Lane
        C[Validate input]
        D{Valid}
        E[Create account]
        F[Send email]
        G[Show success]
        H[Show error]
    end

    A --> B
    B --> C
    C --> D
    D -- Yes --> E
    E --> F
    F --> G
    D -- No --> H
    H --> A
```

---

## 2. Add Expense
```mermaid
flowchart TD
    subgraph User_Lane
        A[Enter expense details]
        B[Click save]
    end

    subgraph System_Lane
        C[Validate amount]
        D{Valid}
        E[Save expense]
        F[Update totals]
        G[Check alert]
        H[Show success]
        I[Show error]
    end

    A --> B
    B --> C
    C --> D
    D -- Yes --> E
    E --> F
    F --> G
    G --> H
    D -- No --> I
```

---

## 3. Set Budget
```mermaid
flowchart TD
    subgraph User_Lane
        A[Enter budget]
        B[Submit]
    end

    subgraph System_Lane
        C[Validate]
        D{Valid}
        E[Save budget]
        F[Confirm]
        G[Error]
    end

    A --> B
    B --> C
    C --> D
    D -- Yes --> E
    E --> F
    D -- No --> G
```

---

## 4. Budget Alert
```mermaid
flowchart TD
    subgraph System_Lane
        A[Monitor spending]
        B{Limit reached}
        C[Create alert]
        D[Notify user]
        E[Continue]
    end

    subgraph User_Lane
        F[View alert]
        G[Dismiss]
    end

    A --> B
    B -- Yes --> C
    C --> D
    D --> F
    F --> G
    B -- No --> E
    E --> A
```

---

## 5. Export CSV
```mermaid
flowchart TD
    subgraph User_Lane
        A[Request export]
    end

    subgraph System_Lane
        B[Queue job]
        C[Generate file]
        D[Log request]
        E[Download]
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
    subgraph User_Lane
        A[Select expense]
        B[Edit details]
        C[Save]
    end

    subgraph System_Lane
        D[Validate]
        E{Valid}
        F[Update]
        G[Recalculate]
        H[Success]
        I[Error]
    end

    A --> B
    B --> C
    C --> D
    D --> E
    E -- Yes --> F
    F --> G
    G --> H
    E -- No --> I
```

---

## 7. Delete Expense
```mermaid
flowchart TD
    subgraph User_Lane
        A[Select expense]
        B[Delete]
    end

    subgraph System_Lane
        C[Confirm]
        D{Yes or No}
        E[Delete expense]
        F[Update totals]
        G[Done]
        H[Cancel]
    end

    A --> B
    B --> C
    C --> D
    D -- Yes --> E
    E --> F
    F --> G
    D -- No --> H
```

---

## 8. Monthly Summary
```mermaid
flowchart TD
    subgraph User_Lane
        A[Select month]
        B[Request]
    end

    subgraph System_Lane
        C[Process data]
        D[Generate chart]
        E[Display]
    end

    A --> B
    B --> C
    C --> D
    D --> E
```
