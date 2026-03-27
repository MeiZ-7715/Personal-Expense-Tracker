# Test Cases – Personal Expense Tracker

## Functional Test Cases

| Test ID | Requirement ID | Description | Steps | Expected Result |
|---------|---------------|-------------|-------|-----------------|
| TC‑001 | FR‑01 | Register new user with valid details | 1. Enter email (nomalizo@gmail.com), password (Secure123), confirm.<br>2. Submit. | Account created; verification email sent; user logged in. |
| TC‑002 | FR‑01 | Register with existing email | 1. Use email that already exists.<br>2. Submit. | Error: “Email already registered”. |
| TC‑003 | FR‑02 | Login with correct credentials | 1. Enter registered email/password.<br>2. Submit. | Redirect to dashboard; session active. |
| TC‑004 | FR‑02 | Login with incorrect password | 1. Correct email, wrong password.<br>2. Submit. | Error: “Invalid credentials”. |
| TC‑005 | FR‑03 | Add expense with positive amount | 1. Amount: 350.00 ZAR, Category: Groceries, Description: “Woolworths”.<br>2. Submit. | Expense saved; dashboard total updated. |
| TC‑006 | FR‑03 | Add expense with zero amount | 1. Amount: 0 ZAR.<br>2. Submit. | Error: “Amount must be greater than 0”. |
| TC‑007 | FR‑04 | Edit expense amount | 1. Select an expense of R250.<br>2. Edit amount to R300.<br>3. Save. | Expense updated; total changes accordingly. |
| TC‑008 | FR‑05 | Filter expenses by category | 1. Click “Filter”.<br>2. Select “Transport”.<br>3. Apply. | Only expenses in Transport category displayed. |
| TC‑009 | FR‑06 | Generate monthly summary for February | 1. Select month February.<br>2. Click “Show Summary”. | Pie chart appears; totals per category displayed. |
| TC‑010 | FR‑08 | Set budget for category | 1. Go to Budget page.<br>2. Category: Groceries, Budget: 2500.<br>3. Save. | Budget saved; alert triggers at 2000. |
| TC‑011 | FR‑09 | Export data to CSV | 1. Click “Export”.<br>2. Choose “All”. | CSV file downloaded with all expenses. |
| TC‑012 | FR‑11 | Search expenses by keyword | 1. Enter “Checkers” in search box.<br>2. Click Search. | List shows expenses containing “Checkers”. |
| TC‑013 | FR‑12 | Add shared expense (family member) | 1. Family member logs in.<br>2. Add expense, toggle “Shared”.<br>3. Submit. | Expense visible to both household members. |

## Non‑Functional Test Cases

| Test ID | Category | Description | Steps | Expected Result |
|---------|----------|-------------|-------|-----------------|
| NFT‑001 | Performance | Page load time for expense list | 1. Use browser dev tools (Network tab).<br>2. Load expense list with 500 records. | Load ≤ 2 seconds. |
| NFT‑002 | Performance | Concurrent user load | 1. Simulate 1000 concurrent users (JMeter).<br>2. All users log in and view dashboard. | Average response ≤ 2 seconds; no errors. |
| NFT‑003 | Security | Password storage | 1. Register a new user.<br>2. Inspect database password column. | Passwords hashed with BCrypt; no plain text. |
| NFT‑004 | Security | HTTPS enforcement | 1. Attempt to access via HTTP.<br>2. Verify redirect to HTTPS. | All traffic uses HTTPS. |
| NFT‑005 | Usability | Mobile responsiveness | 1. Open site on a smartphone (Samsung/iPhone).<br>2. Navigate through pages. | Layout adjusts; buttons clickable; no horizontal scroll. |
| NFT‑006 | Deployability | Docker deployment | 1. Run `docker‑compose up` on a clean Ubuntu 22.04 server.<br>2. Access application at http://localhost. | System runs without manual configuration. |
| NFT‑007 | Maintainability | API documentation | 1. Start application.<br>2. Visit `/swagger` endpoint. | Swagger UI displays all API endpoints. |
| NFT‑008 | Scalability | Database growth | 1. Insert 1 million expense records.<br>2. Run query: total spending per category for a month. | Query returns ≤ 3 seconds. |
