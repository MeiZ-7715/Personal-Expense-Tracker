# Personal Expense Tracker

A web application that helps users record their daily expenses, categorise them, and generate monthly reports to understand spending habits.

## Links
- [System Specification](SPECIFICATION.md)
- [Architecture Documentation](ARCHITECTURE.md)
- [Stakeholder Analysis](STAKEHOLDER_ANALYSIS.md)
- [System Requirements](SYSTEM_REQUIREMENTS.md)
- [Reflection on Stakeholder Needs](REFLECTION.md)
- [Use Case Diagram](USE_CASE_DIAGRAM.md)
- [Use Case Specifications](USE_CASE_SPECIFICATIONS.md)
- [Test Cases](TEST_CASES.md)
- [Reflection – Assignment 5](REFLECTION_ASSIGNMENT5.md)
- [Agile Planning Document (User Stories, Backlog, Sprint Plan)](AGILE_PLANNING.md)
- [Template Analysis](TEMPLATE_ANALYSIS.md)
- [Kanban Explanation](KANBAN_EXPLANATION.md)
- [Reflection – Assignment 7](REFLECTION_ASSIGNMENT7.md)
- [State Transition Diagrams](STATE_TRANSITION_DIAGRAMS.md)
- [Activity Diagrams](ACTIVITY_DIAGRAMS.md)
- [Reflection – Assignment 8](REFLECTION_ASSIGNMENT8.md)
- [Domain Model](DOMAIN_MODEL.md)
- [Class Diagram](CLASS_DIAGRAM.md)
- [Reflection – Assignment 9](REFLECTION_ASSIGNMENT9.md)
## Assignment 10: From Class Diagrams to Code

### Language Choice
I chose **Java 17** because of its strong object‑oriented features and wide support for design patterns and unit testing (JUnit 5). All code is written in plain Java with no external frameworks.

### How to Run the Code
1. Clone this repository.
2. Compile the source code:
   ```bash
   javac -d out src/main/java/com/expense/model/*.java src/main/java/com/expense/creational/*.java

   ## Assignment 11: Repository Pattern and Storage Abstraction

### Repository Interfaces
We defined a generic `Repository<T, ID>` interface with standard CRUD methods. All entity‑specific repositories (UserRepository, ExpenseRepository, etc.) extend this generic interface and add custom query methods (e.g., `findByEmail`).

### In‑Memory Implementation
The `inmemory` package contains HashMap‑based implementations of all repositories. A base class `InMemoryRepository` avoids code duplication. These implementations are perfect for fast unit tests and prototyping.

### Storage Abstraction with Factory Pattern
A `RepositoryFactory` class provides static methods to obtain the correct repository implementation based on a configuration string (e.g., `"MEMORY"` or `"DATABASE"`). This makes switching storage backends trivial – just change one argument.

### Future‑Proofing
Stub classes (e.g., `DatabaseUserRepository`) are already created in the `database` package. Adding a real database (MySQL, MongoDB) would only require implementing the existing interfaces – no changes to business logic.

### How to Run Tests
All in‑memory repositories have JUnit 5 tests. To run them:
```bash
mvn test
## Assignment 12: Service Layer and REST API

### Service Layer
- `UserService`, `ExpenseService`, `BudgetService` contain business rules:
  - Email must be unique when creating a user.
  - Expense amount must be > 0 ZAR.
  - Adding an expense automatically updates the spent amount in the related budget (if it exists).
- Services use the in‑memory repositories from Assignment 11.

### REST API (Spring Boot)
All endpoints are prefixed with `/api`.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/users` | Create a new user |
| GET    | `/api/users/{userId}` | Get user by ID |
| GET    | `/api/users` | Get all users |
| POST   | `/api/expenses` | Add a new expense |
| GET    | `/api/expenses/user/{userId}` | Get all expenses of a user |
| POST   | `/api/budgets` | Set or update a monthly budget |
| GET    | `/api/budgets/user/{userId}` | Get all budgets of a user |

### API Documentation (Swagger)
Once the application is running, interactive Swagger UI is available at:  
`http://localhost:8080/swagger-ui.html`

### How to Run the API
1. Make sure you have Java 17 and Maven installed.
2. In the project root, run:
   ```bash
   mvn spring-boot:run
