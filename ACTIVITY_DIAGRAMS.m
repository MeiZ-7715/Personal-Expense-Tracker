
# Activity Diagrams – Personal Expense Tracker

All amounts in ZAR.

---

## 1. User Registration Workflow
```mermaid
flowchart TD
    A[Enter email & password] --> B[Submit]
    B --> C[Validate email & password]

    C -->|Valid| D[Create account]
    D --> E[Send verification email]
    E --> F[Show success & auto-login]

    C -->|Invalid| G[Show error]
    G --> A
```
**Explanation:**  
User enters details → system validates → if valid, account is created and user logs in. If invalid, error is shown and user retries.

---

## 2. Add Expense
```mermaid
flowchart TD
    A[Enter expense details] --> B[Click Save]
    B --> C[Validate amount > 0]

    C -->|Valid| D[Save expense]
    D --> E[Update totals]
    E --> F[Show success]
    E --> G[Check budget alert]

    C -->|Invalid| H[Show error]
```
**Explanation:**  
User adds expense → system validates → if valid, saves and updates totals → also checks budget alert.

---

## 3. Set Monthly Budget
```mermaid
flowchart TD
    A[Enter budget amount] --> B[Submit]
    B --> C[Validate amount > 0]

    C -->|Valid| D[Save budget]
    D --> E[Show confirmation]

    C -->|Invalid| F[Show error]
```
**Explanation:**  
User sets budget → system validates → saves if valid, otherwise shows error.

---

## 4. Budget Alert Trigger
```mermaid
flowchart TD
    A[Monitor spending] --> B{Spending >= 80%?}

    B -->|Yes| C[Create alert]
    C --> D[Notify user]
    D --> E[User dismisses]

    B -->|No| F[Continue monitoring]
```
**Explanation:**  
System monitors spending → triggers alert if threshold reached → otherwise continues.

---

## 5. Export CSV
```mermaid
flowchart TD
    A[Request export] --> B[Queue job]

    B --> C[Generate CSV]
    B --> D[Log request]

    C --> E[Download file]
    D --> E
```
**Explanation:**  
Export request is queued → system generates file and logs action in parallel → user downloads file.

---

## 6. Edit Expense
```mermaid
flowchart TD
    A[Select expense] --> B[Modify details]
    B --> C[Save changes]
    C --> D[Validate amount > 0]

    D -->|Valid| E[Update expense]
    E --> F[Recalculate totals]
    F --> G[Show success]

    D -->|Invalid| H[Show error]
```
**Explanation:**  
User edits expense → system validates → updates if valid, otherwise error.

---

## 7. Delete Expense
```mermaid
flowchart TD
    A[Select expense] --> B[Click delete]
    B --> C{Confirm?}

    C -->|Yes| D[Delete expense]
    D --> E[Update totals]
    E --> F[Show confirmation]

    C -->|No| G[Cancel action]
```
**Explanation:**  
User deletes expense → system asks for confirmation → deletes only if confirmed.

---

## 8. View Monthly Summary
```mermaid
flowchart TD
    A[Select month] --> B[Request summary]
    B --> C[Aggregate expenses]
    C --> D[Generate chart data]
    D --> E[Display summary]
```
**Explanation:**  
User requests summary → system processes data → displays results.
