# System Requirements Document – Personal Expense Tracker

This document specifies the functional and non‑functional requirements for the Personal Expense Tracker system.

## 1. Functional Requirements 

| ID | Requirement | Acceptance Criteria |
|----|-------------|---------------------|
| FR-01 | The system shall allow a user to register with a unique email and password. | - Email format validation.<br>- Password strength indicator.<br>- Confirmation email sent. |
| FR-02 | The system shall allow a user to log in using email and password. | - Invalid credentials show error message.<br>- Session persists for 24 hours. |
| FR-03 | The system shall allow a user to add a new expense with amount (in ZAR), category, date, and description. | - Amount must be positive.<br>- Date defaults to today.<br>- Category selected from predefined list or user‑defined. |
| FR-04 | The system shall allow a user to edit or delete an existing expense. | - Changes reflected immediately.<br>- Delete requires confirmation. |
| FR-05 | The system shall display a list of all expenses with sort and filter options (by date, category, amount). | - Filter by date range works.<br>- Sort by amount ascending/descending. |
| FR-06 | The system shall generate a monthly summary showing total spent per category and a pie chart. | - Summary updates in real time.<br>- Chart rendered using Chart.js or similar. |
| FR-07 | The system shall allow users to create custom spending categories. | - New category appears in dropdown.<br>- Cannot duplicate existing category name. |
| FR-08 | The system shall allow users to set a monthly budget for each category and receive alerts when approaching the limit. | - Alert when spending reaches 80% of budget.<br>- Budget exceeded notification. |
| FR-09 | The system shall support exporting expense data to CSV format. | - Export includes all fields.<br>- File downloaded with proper naming. |
| FR-10 | The system shall allow users to view a dashboard with total spending, remaining budget, and recent transactions. | - Dashboard loads within 2 seconds.<br>- Data refreshes on each visit. |
| FR-11 | The system shall provide a search feature to find expenses by keyword in description. | - Search returns matching results.<br>- Search is case‑insensitive. |
| FR-12 | The system shall support multi‑user accounts for shared household expenses (optional). | - Users can link accounts.<br>- Shared expenses visible to both. |

## 2. Non‑Functional Requirements 

| Category | Requirement | Measurable Criterion |
|----------|-------------|----------------------|
| **Usability** | The system shall be accessible on both desktop and mobile browsers. | Responsive design passes Google Mobile‑Friendly Test. |
| Usability | The interface shall follow WCAG 2.1 Level AA accessibility guidelines. | Screen reader compatible; colour contrast ratio ≥4.5:1. |
| **Deployability** | The system shall be deployable on a Linux server using Docker containers. | One‑command deployment via `docker‑compose up`. |
| Deployability | The system shall support both development (H2) and production (MySQL) databases via configuration. | Database switch requires only environment variable change. |
| **Maintainability** | Source code shall include inline comments for all public methods. | At least 80% of public methods have Javadoc comments. |
| Maintainability | API endpoints shall be documented using OpenAPI/Swagger. | Swagger UI available at `/swagger` when running. |
| **Scalability** | The system shall handle up to 1,000 concurrent users during peak hours. | Response time under 2 seconds under load test (JMeter). |
| Scalability | The database shall support up to 1 million expense records without performance degradation. | Queries on large dataset return within 3 seconds. |
| **Security** | All user passwords shall be hashed using BCrypt. | No plain‑text storage; hashes use salt. |
| Security | All data transmitted between client and server shall be encrypted via HTTPS. | SSL certificate configured; HTTP requests redirect to HTTPS. |
| Security | User session tokens shall expire after 24 hours and be stored securely. | Tokens are HTTP‑only cookies. |
| **Performance** | Expense list page shall load within 2 seconds for 500 transactions. | Measured with browser developer tools. |
| Performance | Search queries shall return results within 1 second for up to 10,000 records. | Indexed search field. |
