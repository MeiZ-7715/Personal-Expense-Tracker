# Use Case Specifications – Personal Expense Tracker

All monetary amounts are in **South African Rand (ZAR)**.

## 1. Register Account

| Field | Detail |
|-------|--------|
| **Actor** | Guest |
| **Description** | The guest creates a new account to start tracking expenses. |
| **Preconditions** | None. |
| **Postconditions** | A new user record is created; the user is automatically logged in. |
| **Basic Flow** | 1. Guest clicks “Sign Up”.<br>2. Guest enters email (e.g., thabo@gmail.com) and password.<br>3. System validates email format and password strength (min 8 chars, one number).<br>4. System creates account and sends verification email.<br>5. System logs user in and redirects to dashboard. |
| **Alternative Flows** | 3a. Email already exists → System shows error, offers “Forgot password?” link.<br>3b. Password too weak → System displays requirements and prompts re‑entry. |

## 2. Login

| Field | Detail |
|-------|--------|
| **Actor** | User, Family Member |
| **Description** | The user authenticates to access protected features. |
| **Preconditions** | User is registered. |
| **Postconditions** | User session created; dashboard displayed. |
| **Basic Flow** | 1. User enters email and password.<br>2. System validates credentials.<br>3. System creates a session token and redirects to dashboard. |
| **Alternative Flows** | 2a. Invalid credentials → System displays error and allows retry.<br>2b. Account locked after 5 failed attempts → System sends password reset email. |

## 3. Add Expense

| Field | Detail |
|-------|--------|
| **Actor** | User, Family Member |
| **Description** | The user records a new expense. Typical expenses in South Africa might be groceries at Checkers, petrol, or electricity. |
| **Preconditions** | User is logged in. |
| **Postconditions** | Expense is saved; total spending updates; budget alerts checked. |
| **Basic Flow** | 1. User clicks “Add Expense”.<br>2. User enters amount in ZAR (e.g., 250.50), selects category (e.g., “Groceries”), picks date (default today), adds description (e.g., “Checkers – weekly shop”).<br>3. System validates amount > 0.<br>4. System saves expense and displays success message.<br>5. System refreshes dashboard. |
| **Alternative Flows** | 3a. Amount ≤ 0 → System shows error, prompts for positive amount.<br>3b. Category missing → System defaults to “Other”.<br>3c. Description missing → System accepts (optional). |

## 4. Set Monthly Budget

| Field | Detail |
|-------|--------|
| **Actor** | User |
| **Description** | The user sets a spending limit per category for the current month (e.g., R2000 for Groceries, R800 for Transport). |
| **Preconditions** | User is logged in. |
| **Postconditions** | Budget saved; alerts enabled for that category. |
| **Basic Flow** | 1. User navigates to Budget page.<br>2. User selects a category (e.g., “Transport”).<br>3. User enters budget amount (e.g., 1500).<br>4. System validates amount > 0.<br>5. System saves budget and confirms. |
| **Alternative Flows** | 4a. Amount ≤ 0 → System rejects and asks for valid amount.<br>4b. Budget already exists → System asks if user wants to update. |

## 5. Receive Budget Alert

| Field | Detail |
|-------|--------|
| **Actor** | User |
| **Description** | The system notifies the user when spending in a category reaches 80% of the budget. |
| **Preconditions** | User is logged in; budget is set for the category. |
| **Postconditions** | Alert displayed (and logged). |
| **Basic Flow** | 1. System monitors total spending per category in real‑time.<br>2. When total ≥ 80% of budget, system shows a pop‑up: “You’ve spent R1600 of R2000 on Groceries”.<br>3. User dismisses alert. |
| **Alternative Flows** | 2a. Spending exceeds 100% → System sends “Over budget” alert with extra emphasis. |

## 6. View Monthly Summary

| Field | Detail |
|-------|--------|
| **Actor** | User, Family Member, Product Owner |
| **Description** | The user views total spending per category for a selected month, with a pie chart. |
| **Preconditions** | User is logged in. |
| **Postconditions** | Summary displayed. |
| **Basic Flow** | 1. User selects a month (e.g., March 2026) from dropdown.<br>2. System aggregates expenses by category (e.g., Groceries: R3200, Transport: R850).<br>3. System displays table and interactive pie chart. |
| **Alternative Flows** | 2a. No expenses for that month → System shows “No expenses recorded for this month”. |

## 7. Search Expenses

| Field | Detail |
|-------|--------|
| **Actor** | User |
| **Description** | The user finds expenses by keyword in the description. |
| **Preconditions** | User is logged in. |
| **Postconditions** | Matching expenses displayed. |
| **Basic Flow** | 1. User enters keyword in search box (e.g., “Checkers”).<br>2. System searches all descriptions (case‑insensitive).<br>3. System shows list of expenses containing the keyword. |
| **Alternative Flows** | 2a. No matches → System shows “No expenses found”. |

## 8. Export Expenses

| Field | Detail |
|-------|--------|
| **Actor** | User, Data Analyst, System Administrator |
| **Description** | The user downloads all expenses in CSV format for external use (e.g., tax submission to SARS). |
| **Preconditions** | User is logged in. |
| **Postconditions** | CSV file is generated and downloaded. |
| **Basic Flow** | 1. User clicks “Export”.<br>2. System prompts for date range (optional).<br>3. User selects “All” or a range.<br>4. System generates CSV with columns: Date, Category, Amount (ZAR), Description.<br>5. File is downloaded (e.g., “expenses_20260327.csv”). |
| **Alternative Flows** | 3a. No expenses in range → System shows message and does not generate file. |

## 9. Manage Shared Expenses

| Field | Detail |
|-------|--------|
| **Actor** | Family Member |
| **Description** | A family member adds an expense and marks it as shared (visible to both members of the household). |
| **Preconditions** | Family Member is logged in and part of a shared household (e.g., a couple sharing a flat in Cape Town). |
| **Postconditions** | Expense saved with “shared” flag; visible to both accounts. |
| **Basic Flow** | 1. Family Member clicks “Add Expense”.<br>2. Enters amount, category, date, description.<br>3. Toggles “Shared with household” checkbox.<br>4. System validates and saves expense with shared flag.<br>5. Other household member sees the expense in their list. |
| **Alternative Flows** | 4a. Amount ≤ 0 → System rejects. |
