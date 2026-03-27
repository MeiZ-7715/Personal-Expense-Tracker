# Reflection: Challenges in Translating Requirements to Use Cases and Tests

When moving from the requirements document (Assignment 4) to use cases and test cases (Assignment 5), I encountered several challenges that taught me valuable lessons about system design and validation.

## 1. Bridging the Gap Between High‑Level Requirements and Concrete Interactions

The functional requirements in Assignment 4 were fairly high‑level: “The system shall allow a user to add a new expense”. While this describes a capability, it does not capture the full user goal. I had to decide which use cases were truly distinct. For example, should “Add Expense” and “Manage Shared Expenses” be separate? I chose to keep them separate because the latter adds a specific precondition (household account) and a postcondition (visibility to another user). This separation makes testing easier but adds complexity to the diagram.

## 2. Deciding on Include/Extend Relationships

Using UML stereotypes like `<<includes>>` and `<<extends>>` was tricky. I initially wanted to include “Login” in every use case, but that would clutter the diagram. I settled on including it only for actions that absolutely require authentication (Add, Edit, Delete, Set Budget). For “Receive Budget Alert”, I used `<<extends>>` because the alert is an optional behaviour that only occurs when a budget exists. I had to justify these choices in the explanation to show my reasoning.

## 3. Writing Alternative Flows

One of the biggest challenges was imagining realistic error scenarios. For example, while writing the “Add Expense” specification, I had to think about what happens if the user enters a negative amount or leaves the category blank. In a real South African context, a user might accidentally type “-100” or forget to select a category. Capturing these alternatives ensures the system is robust. I also added a description field as optional because users often just want to quickly log an expense.


## 4. Creating Test Cases That Are Both Comprehensive and Practical

Translating use cases to test cases required me to think about coverage. For each functional requirement, I wrote at least one positive test (happy path) and one negative test (error handling). I also included a test for the shared expense feature because it was a key stakeholder concern from Assignment 4. For non‑functional requirements, I had to define measurable criteria. For instance, “performance” became “page loads within 2 seconds” and “database query returns ≤ 3 seconds”. These metrics are objective and can be verified with tools like JMeter.

## 5. Maintaining Consistency Across Assignments

A major requirement was that the use cases and tests must trace back to the stakeholder analysis from Assignment 4. I revisited the stakeholder table and ensured that each use case addresses at least one stakeholder concern. For example, “Export Expenses” directly supports the Data Analyst and System Administrator. “Manage Shared Expenses” directly addresses the Family Member stakeholder. This traceability demonstrates that the design is driven by real needs, not just academic exercises.

## Conclusion

This assignment reinforced that use cases and test cases are not just formalities; they are essential tools for ensuring that the final system meets stakeholder expectations. The challenges I faced—especially in defining alternative flows and non‑functional test scenarios—highlighted the importance of thinking like both a user and a tester. I’m confident that the artifacts I produced will serve as a solid foundation for the next phase of development.
