# Domain Model – Personal Expense Tracker

**Project:** Personal Expense Tracker   
**Based on:** Assignments 4 (requirements), 5 (use cases), 8 (state/activity diagrams)

This domain model describes the key entities, their attributes, responsibilities (methods), relationships, and business rules.

## Core Entities (6)

| Entity | Attributes | Methods | Relationships |
|--------|------------|---------|---------------|
| **User** | - userId: String (PK)<br>- email: String<br>- passwordHash: String<br>- isVerified: Boolean<br>- createdAt: Date | + register()<br>+ login()<br>+ updateProfile()<br>+ deleteAccount() | 1 User → * Expenses<br>1 User → * Budgets<br>1 User → * Alerts<br>1 User → * SharedExpenses (as owner) |
| **Expense** | - expenseId: String (PK)<br>- amount: Double (ZAR)<br>- description: String<br>- date: LocalDate<br>- categoryId: String (FK)<br>- userId: String (FK)<br>- isShared: Boolean | + save()<br>+ edit()<br>+ delete() | * Expenses → 1 Category<br>* Expenses → 1 User |
| **Category** | - categoryId: String (PK)<br>- name: String<br>- type: String (default/custom)<br>- isActive: Boolean | + createCustom()<br>+ deactivate()<br>+ delete() | 1 Category → * Expenses<br>1 Category → * Budgets |
| **Budget** | - budgetId: String (PK)<br>- categoryId: String (FK)<br>- userId: String (FK)<br>- month: YearMonth<br>- amountLimit: Double (ZAR)<br>- spentAmount: Double (ZAR) | + setBudget()<br>+ updateSpent()<br>+ checkThreshold() | 1 Budget → 1 Category<br>1 Budget → 1 User |
| **Alert** | - alertId: String (PK)<br>- userId: String (FK)<br>- budgetId: String (FK)<br>- message: String<br>- triggeredAt: Date<br>- status: String (pending/dismissed/expired) | + trigger()<br>+ dismiss()<br>+ expire() | 1 Alert → 1 User<br>1 Alert → 1 Budget |
| **SharedExpense** | - shareId: String (PK)<br>- expenseId: String (FK)<br>- ownerId: String (FK)<br>- sharedWithId: String (FK)<br>- status: String (pending/accepted/rejected) | + invite()<br>+ accept()<br>+ reject() | 1 SharedExpense → 1 Expense<br>1 SharedExpense → 1 User (owner)<br>1 SharedExpense → 1 User (sharedWith) |

## Business Rules

1. **Expense amount** must be > 0 ZAR.  
2. **Budget limit** must be > 0 ZAR.  
3. A user can have **only one active budget per category per month**.  
4. An alert is triggered when `spentAmount >= 0.8 * amountLimit` for a budget.  
5. A category can be deleted **only if no expenses are linked** to it.  
6. A shared expense is **visible to both users** only after the second user accepts it.  
7. Password hashing (BCrypt) is mandatory – plain text never stored.

## Traceability to Previous Assignments

- **FR-03, FR-04, FR-07, FR-08, FR-11, FR-12** (Assignment 4) are directly supported by Expense, Budget, Alert, Category, SharedExpense entities.  
- **User stories US-F01 to US-F08** (Assignment 6) map to methods like `register()`, `addExpense()`, `setBudget()`, etc.  
- **State diagrams** (Assignment 8) for Expense, Budget, Alert, SharedExpense are reflected in the status attributes and methods (e.g., `dismiss()`, `expire()`).  
- **Activity diagrams** (Assignment 8) for workflows like “Add Expense” and “Receive Budget Alert” align with the methods and relationships shown here.
