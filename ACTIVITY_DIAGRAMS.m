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

    A --> B --> C --> D
    D -->|Yes| E --> F --> G
    D -->|No| H --> A
```
**Explanation:**  
The user enters registration details and submits them. The system validates the input. If valid, the account is created and a verification email is sent. If invalid, the system displays an error and the user retries. This supports user registration functionality and ensures valid credentials.

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

    A --> B --> C --> D
    D -->|Yes| E --> F --> G --> H
    D -->|No| I
```
**Explanation:**  
The user enters expense details and saves them. The system validates the amount. If valid, the expense is stored and totals are updated. A budget alert check also runs. If invalid, an error is shown.

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

    A --> B --> C --> D
    D -->|Yes| E --> F
    D -->|No| G
```
**Explanation:**  
The user sets a budget and submits it. The system validates the amount. If valid, the budget is saved; otherwise, an error is displayed.

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
    B -->|Yes| C --> D --> F --> G
    B -->|No| E --> A
```
**Explanation:**  
The system continuously monitors spending. When the threshold is reached, an alert is generated and sent to the user. The user can dismiss the alert. If not reached, monitoring continues.

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
**Explanation:**  
The user requests an export. The system queues the job and performs two parallel actions: generating the file and logging the request. The file is then provided for download.

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

    A --> B --> C --> D --> E
    E -->|Yes| F --> G --> H
    E -->|No| I
```
**Explanation:**  
The user edits an expense and submits changes. The system validates the data. If valid, the expense is updated and totals recalculated. Otherwise, an error is shown.

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

    A --> B --> C --> D
    D -->|Yes| E --> F --> G
    D -->|No| H
```
**Explanation:**  
The user selects and deletes an expense. The system asks for confirmation. If confirmed, the expense is deleted and totals updated. Otherwise, no action is taken.

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

    A --> B --> C --> D --> E
```
**Explanation:**  
The user selects a month and requests a summary. The system processes the data and displays a chart and summary.
