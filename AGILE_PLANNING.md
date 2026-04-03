# Agile Planning Document – Personal Expense Tracker

## 1. User Stories

### 1.1 Functional User Stories (from Assignment 4 requirements)

| Story ID | User Story | Acceptance Criteria | Priority |
|----------|------------|---------------------|----------|
| US‑F01 | As a **user**, I want to **register with my email and password** so that **I can create a secure account**. | - Email format validated.<br>- Password strength check (min 8 chars, 1 number).<br>- Verification email sent. | High |
| US‑F02 | As a **user**, I want to **log in with my credentials** so that **I can access my personal expense data**. | - Invalid credentials show error.<br>- Session lasts 24 hours. | High |
| US‑F03 | As a **user**, I want to **add an expense with amount (in ZAR), category, date, and description** so that **I can record my spending**. | - Amount > 0.<br>- Date defaults to today.<br>- Category from predefined list or user-defined. | High |
| US‑F04 | As a **user**, I want to **edit an existing expense** so that **I can correct mistakes**. | - Changes save immediately.<br>- Updated total reflects new amount. | Medium |
| US‑F05 | As a **user**, I want to **delete an expense** so that **I can remove incorrect entries**. | - Confirmation dialog before deletion.<br>- Expense removed from list. | Medium |
| US‑F06 | As a **user**, I want to **view a monthly summary with a pie chart** so that **I can see where my money goes**. | - Summary shows total per category.<br>- Chart updates when month changes. | High |
| US‑F07 | As a **user**, I want to **set a monthly budget per category** so that **I can control my spending**. | - Budget amount > 0.<br>- Saved per category and month. | High |
| US‑F08 | As a **user**, I want to **receive an alert when I reach 80% of my budget** so that **I can adjust my spending**. | - Alert triggers at 80%.<br>- Notification appears on dashboard. | High |
| US‑F09 | As a **user**, I want to **export my expenses to a CSV file** so that **I can use the data for tax returns (e.g., to SARS)**. | - CSV includes date, category, amount, description.<br>- File downloads with proper name. | Medium |
| US‑F10 | As a **user**, I want to **search expenses by keyword in the description** so that **I can find specific transactions quickly**. | - Search is case‑insensitive.<br>- Results show matching expenses. | Medium |
| US‑F11 | As a **user**, I want to **create custom spending categories** so that **I can personalise my expense tracking**. | - New category appears in dropdown.<br>- Duplicate names not allowed. | Low |
| US‑F12 | As a **family member**, I want to **add an expense and mark it as shared** so that **my household partner can also see it**. | - Shared expense visible to both accounts.<br>- Flag appears in list. | Medium |

### 1.2 Use‑Case‑Derived User Stories (from Assignment 5 use cases)

| Story ID | User Story | Acceptance Criteria | Priority |
|----------|------------|---------------------|----------|
| US‑U01 | As a **guest**, I want to **register an account** so that **I can start tracking expenses**. (same as US‑F01 but from guest perspective) | - As US‑F01. | High |
| US‑U02 | As a **user**, I want to **set a budget and receive alerts** so that **I don’t overspend**. | - Budget saved.<br>- Alert at 80% and 100%. | High |
| US‑U03 | As a **system administrator**, I want to **export all users’ anonymised expense data** so that **I can analyse system usage**. | - CSV with no personal identifiers.<br>- Date range filter. | Low |
| US‑U04 | As a **data analyst**, I want to **export aggregated spending data per category** so that **I can identify trends in South African household spending**. | - Data grouped by category and month.<br>- Anonymised. | Low |
| US‑U05 | As a **product owner**, I want to **view the most used features** so that **I can prioritise future development**. | - Dashboard shows feature usage counts. | Medium |

---

## 2. Product Backlog (MoSCoW Prioritisation + Effort Estimates)

**Story points:** 1 (trivial), 2 (easy), 3 (medium), 5 (complex), 8 (very complex).  
**MoSCoW:** Must-have (critical for MVP), Should-have (important but not vital), Could-have (nice to have), Won't-have (not now).

| Story ID | User Story Summary | MoSCoW | Story Points | Dependencies |
|----------|--------------------|--------|--------------|--------------|
| US‑F01 | Register account | Must | 2 | None |
| US‑F02 | Login | Must | 2 | US‑F01 (user must exist) |
| US‑F03 | Add expense | Must | 3 | US‑F02 (login required) |
| US‑F06 | View monthly summary | Must | 3 | US‑F03 (expenses exist) |
| US‑F07 | Set monthly budget | Must | 2 | US‑F02 |
| US‑F08 | Receive budget alert | Must | 3 | US‑F07 (budget set) |
| US‑F04 | Edit expense | Should | 2 | US‑F03 |
| US‑F05 | Delete expense | Should | 1 | US‑F03 |
| US‑F10 | Search expenses | Should | 3 | US‑F03 |
| US‑F09 | Export CSV | Should | 3 | US‑F03 |
| US‑F12 | Shared expenses (family) | Could | 5 | US‑F03, US‑F02 |
| US‑F11 | Custom categories | Could | 2 | US‑F03 |
| US‑U03 | Admin export anonymised | Won’t | 5 | US‑F09 |
| US‑U04 | Analyst aggregated data | Won’t | 5 | US‑F09 |
| US‑U05 | Product owner usage stats | Could | 3 | US‑F02 |

### Justification of Prioritisation (MoSCoW)

- **Must-have** stories form the **Minimum Viable Product (MVP)**. Without registration, login, adding expenses, viewing summaries, setting budgets, and receiving alerts, the system would not fulfil the primary user goal: tracking spending and avoiding overspending. These align directly with the stakeholder success metrics from Assignment 4 (e.g., “reduce monthly spending by 10%” requires budget alerts).

- **Should-have** stories (edit, delete, search, export) are important for a complete user experience but not strictly required for the first release. A user could live without editing if they delete and re‑add, but that’s frustrating. Export is needed for tax (SARS) but can wait one sprint.

- **Could-have** stories (shared expenses, custom categories, usage stats) add value but require more complex logic (e.g., household relationships). They are postponed.

- **Won’t-have** stories (admin/anonymised exports) are for future phases. They are not needed for individual users.

**Effort estimation reasoning:**  
- Simple CRUD operations (delete) = 1 point.  
- Forms with validation (register, login, add expense) = 2‑3 points.  
- Complex logic (budget alert monitoring, shared expenses) = 3‑5 points.  
- Dependencies noted (e.g., login must exist before adding expense).

---

## 3. Sprint Planning

### Sprint Goal (2 weeks)

> **“Implement core expense tracking with budget alerts and monthly summary, enabling a user to register, log in, record expenses, set budgets, and receive overspending alerts.”**

### Sprint Duration

14 days (e.g., Monday 6 April – Sunday 19 April 2026)

### Selected User Stories for Sprint (5 stories)

| Story ID | User Story | MoSCoW | Story Points |
|----------|------------|--------|--------------|
| US‑F01 | Register account | Must | 2 |
| US‑F02 | Login | Must | 2 |
| US‑F03 | Add expense | Must | 3 |
| US‑F06 | View monthly summary | Must | 3 |
| US‑F07 | Set monthly budget | Must | 2 |
| US‑F08 | Receive budget alert | Must | 3 |

**Total story points:** 15

### Sprint Backlog with Tasks

| Story ID | Task Description | Assigned (self) | Estimated Hours |
|----------|------------------|----------------|-----------------|
| US‑F01 | Create database table for users | Backend | 2 |
| US‑F01 | Build registration API endpoint (Spring Boot) | Backend | 3 |
| US‑F01 | Create registration UI page (React) | Frontend | 3 |
| US‑F02 | Implement login API with JWT | Backend | 3 |
| US‑F02 | Build login UI and session management | Frontend | 3 |
| US‑F03 | Create expenses table (DB) | Backend | 2 |
| US‑F03 | Add expense API (POST /expenses) | Backend | 3 |
| US‑F03 | Build “Add Expense” form (frontend) | Frontend | 4 |
| US‑F06 | Create summary API (aggregate by category) | Backend | 4 |
| US‑F06 | Integrate pie chart (Chart.js) on dashboard | Frontend | 4 |
| US‑F07 | Create budgets table (DB) | Backend | 2 |
| US‑F07 | Budget API (set/get) | Backend | 3 |
| US‑F07 | Budget UI (dropdown + input) | Frontend | 3 |
| US‑F08 | Implement background job to check spending vs budget | Backend | 5 |
| US‑F08 | Display alert banner on frontend when threshold reached | Frontend | 3 |
| **Integration & Testing** | End‑to‑end testing, bug fixes | Both | 5 |

**Total estimated hours:** 52 hours (reasonable for a solo developer over 14 days, ~4 hours/day).

### Justification for Sprint Selection

- All selected stories are **Must-have** – they deliver a functional MVP.  
- The sprint goal explicitly focuses on the core value proposition: recording expenses and controlling spending via budgets.  
- Stories are independent enough to be developed in parallel (backend and frontend tasks).  
- Excluded “Should-have” stories (edit, delete, search, export) to keep the sprint achievable. They will be in Sprint 2.

---

## 4. Reflection on Challenges in Prioritisation, Estimation, and Agile Alignment (500+ words)

As the sole stakeholder, product owner, and developer for this project, I faced several internal challenges when applying Agile principles. Normally, a team would negotiate priorities, but here I had to argue with myself.

### 4.1 Deciding What Is “Must‑have”

The biggest struggle was distinguishing between a feature that is truly essential for the MVP and one that is merely desirable. For example, “Set monthly budget” and “Receive budget alert” are not strictly required for a basic expense tracker – one could simply record expenses without alerts. However, the stakeholder success metric from Assignment 4 was “reduce monthly spending by 10%”. Without budget alerts, the system would not actively help the user change behaviour. I therefore elevated these stories to Must‑have, even though they added complexity (background job, real‑time monitoring). This forced me to accept a longer sprint (2 weeks) and more tasks.

### 4.2 Effort Estimation Bias

As a solo developer, I tend to underestimate the time needed for integration and testing. I initially assigned 3 story points to “Receive budget alert” but then realised it requires a scheduled task (e.g., cron job) or an event‑driven check each time an expense is added. That pushed it to 5 points. I also had to add a separate “Integration & Testing” block because frontend‑backend integration often reveals mismatches (e.g., date formats, CORS). I learned to add buffer tasks.

### 4.3 Balancing Technical Debt with Features

I was tempted to include “Search expenses” (Should‑have) because it seems easy, but it would have required indexing and a new API endpoint. Adding it would have risked the sprint goal. I resisted and kept the scope lean. This was difficult because I wanted to impress the lecturer with many features, but Agile taught me to focus on a coherent, testable increment.

### 4.4 Using INVEST Criteria

Writing user stories that are truly independent was hard. For instance, “View monthly summary” depends on having expenses. I made sure the acceptance criteria for earlier stories (Add expense) were fully done before starting the summary story. I also had to split stories: “Set monthly budget” and “Receive budget alert” are separate because the alert is a distinct piece of functionality that can be added later, but I kept them together for the MVP because the value is in the alert.

### 4.5 Aligning with Previous Assignments

I constantly checked traceability: every user story maps to a functional requirement from Assignment 4 or a use case from Assignment 5. For example, US‑F08 (budget alert) traces to FR‑08 and the “Receive Budget Alert” use case. This alignment ensures that the Agile plan is not created in a vacuum but respects earlier analysis.

### 4.6 Internal Resistance to Leaving Out Nice‑to‑Haves

As the only stakeholder, I had to be honest about what I could deliver in two weeks. I really wanted to include “Custom categories” (US‑F11) because it feels empowering, but I recognised it would add UI complexity (dynamic dropdowns) and database changes. I moved it to the product backlog for a future sprint. This was a valuable lesson in saying “no” to myself.

### Conclusion

This exercise demonstrated that Agile is not just about speed but about disciplined prioritisation. Even as a solo developer, following the Scrum framework – sprint goal, backlog, tasks, and reflection – helped me focus on the most valuable features first. The internal conflicts I resolved mirror real team disagreements, and I now appreciate how estimation and prioritisation are skills that improve with practice.
