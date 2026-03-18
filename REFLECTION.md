# Reflection: Balancing Stakeholder Needs

While defining the requirements for the Personal Expense Tracker, I encountered several trade‑offs between different stakeholders’ priorities. Here are the main challenges and how I addressed them.

## 1. Primary User vs. System Administrator
The primary user wants a rich, interactive dashboard with real‑time charts and instant updates. This requires frequent client‑server communication and complex data aggregation, which can increase server load. The system administrator, on the other hand, prioritizes low resource usage and high uptime.  
**Compromise:** I opted for client‑side rendering of charts using cached data, with the server providing aggregated data only when necessary. This reduces server load while keeping the user experience smooth.

## 2. Family Member (Shared Account) vs. Data Analyst
Family members need the ability to tag expenses as “shared” and see them immediately, which implies real‑time synchronization. The data analyst, however, requires consistent, anonymized data exports without duplication. Real‑time sync can lead to temporary inconsistencies.  
**Compromise:** I introduced a “shared” flag and used a last‑write‑wins strategy to avoid duplicates. For analysis, exports are generated from a consistent snapshot to ensure accuracy.

## 3. Developer vs. Product Owner
Developers want a clean, modular codebase with thorough documentation, which takes time. The product owner wants features delivered quickly to satisfy users.  
**Compromise:** We agreed on an 80% test coverage target and mandatory Javadoc for public methods, but we prioritised feature delivery for the first release, with documentation and refactoring scheduled for subsequent sprints.

## 4. Security vs. Usability
Strong security (e.g., complex password requirements, frequent logouts) can frustrate users.  
**Compromise:** We implemented BCrypt hashing and HTTPS, but kept session length at 24 hours and allowed password managers to simplify login. We also added optional two‑factor authentication for users who desire extra security.

Balancing these concerns required constant communication and prioritisation. The final set of requirements aims to satisfy the most critical needs of each stakeholder while acknowledging that perfect satisfaction for all is impossible. This exercise reinforced the importance of trade‑off analysis in real‑world software projects.
