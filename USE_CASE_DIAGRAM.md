# Use Case Diagram – Personal Expense Tracker

The diagram below shows how different actors interact with the system.  
All monetary amounts are in **South African Rand (ZAR)**.

```mermaid
graph TD
    %% Actors
    User([User])
    FamilyMember([Family Member])
    SysAdmin([System Administrator])
    DataAnalyst([Data Analyst])
    Developer([Developer])
    ProductOwner([Product Owner])
    Guest([Guest])

    %% Use Cases
    Register[Register Account]
    Login[Login]
    AddExpense[Add Expense]
    EditExpense[Edit Expense]
    DeleteExpense[Delete Expense]
    ViewSummary[View Monthly Summary]
    SetBudget[Set Monthly Budget]
    ReceiveAlert[Receive Budget Alert]
    ExportData[Export Expenses]
    SearchExpenses[Search Expenses]
    ManageCategories[Manage Categories]
    ManageSharedExpenses[Manage Shared Expenses]

    %% Relationships
    Guest --> Register
    Guest --> Login
    User --> AddExpense
    User --> EditExpense
    User --> DeleteExpense
    User --> ViewSummary
    User --> SetBudget
    User --> ReceiveAlert
    User --> ExportData
    User --> SearchExpenses
    User --> ManageCategories

    FamilyMember --> Login
    FamilyMember --> AddExpense
    FamilyMember --> ManageSharedExpenses
    FamilyMember --> ViewSummary

    SysAdmin --> ManageCategories
    SysAdmin --> ExportData

    DataAnalyst --> ExportData

    Developer --> ManageCategories
    ProductOwner --> ViewSummary

    %% Include/Extend
    AddExpense -.-> |<<includes>>| Login
    EditExpense -.-> |<<includes>>| Login
    DeleteExpense -.-> |<<includes>>| Login
    SetBudget -.-> |<<includes>>| Login
    ReceiveAlert -.-> |<<extends>>| SetBudget
    ManageSharedExpenses -.-> |<<includes>>| AddExpense
