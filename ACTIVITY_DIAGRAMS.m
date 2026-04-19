# Activity Diagrams – Personal Expense Tracker

---

## 1. User Registration Workflow
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>User: Enter email and password
    User->>System: Submit
    System->>System: Validate input
    alt valid
        System->>System: Create account
        System->>User: Success message
    else invalid
        System->>User: Error message
        User->>User: Re-enter details
    end
```
**Explanation:** User registers → system validates → success or retry.  
**Maps to:** FR-01

---

## 2. Add Expense
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>User: Enter expense details
    User->>System: Save
    System->>System: Validate amount
    alt valid
        System->>System: Save expense
        System->>User: Success
    else invalid
        System->>User: Error
    end
```
**Explanation:** Expense saved if valid amount.  
**Maps to:** FR-03

---

## 3. Set Budget
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>User: Enter budget
    User->>System: Submit
    System->>System: Validate
    alt valid
        System->>System: Save budget
        System->>User: Confirmation
    else invalid
        System->>User: Error
    end
```
**Explanation:** Budget saved if valid.  
**Maps to:** FR-07

---

## 4. Budget Alert
```mermaid
sequenceDiagram
    participant System
    participant User
    loop Monitor spending
        System->>System: Check total
        alt limit reached
            System->>User: Alert
            User->>System: Dismiss
        else not reached
            System->>System: Continue
        end
    end
```
**Explanation:** System monitors and alerts user.  
**Maps to:** FR-08

---

## 5. Export CSV
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>System: Request export
    System->>System: Queue job
    par Generate file
        System->>System: Create CSV
    and Log
        System->>System: Log request
    end
    System->>User: Download
```
**Explanation:** Export runs with parallel processing.  
**Maps to:** FR-09

---

## 6. Edit Expense
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>User: Edit expense
    User->>System: Save changes
    System->>System: Validate
    alt valid
        System->>System: Update expense
        System->>User: Success
    else invalid
        System->>User: Error
    end
```
**Explanation:** Updates only if valid.  
**Maps to:** FR-04

---

## 7. Delete Expense
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>System: Delete expense
    System->>System: Confirm
    alt yes
        System->>System: Delete
        System->>User: Confirmed
    else no
        System->>User: Cancelled
    end
```
**Explanation:** Requires confirmation before delete.  
**Maps to:** FR-04

---

## 8. Monthly Summary
```mermaid
sequenceDiagram
    participant User
    participant System
    User->>System: Request summary
    System->>System: Process data
    System->>System: Generate chart
    System->>User: Display results
```
**Explanation:** System processes and shows summary.  
**Maps to:** FR-06
