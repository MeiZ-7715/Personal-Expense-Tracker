# Reflection: State Modeling and Activity Workflow – Assignment 8

## Challenges Faced

### 1. Choosing the Right Granularity for States
Deciding how many states to include for each object was difficult. For example, the `Expense` object could have had more intermediate states like "Pending sync", but that would clutter the diagram. I settled on four states (Draft, Saved, Edited, Deleted) because they capture the essential lifecycle without overcomplicating. Too few states would miss important transitions (e.g., edit before save); too many would make the diagram unreadable.

### 2. Defining Guard Conditions
Guard conditions ensure valid transitions. For the `Budget` object, I added a guard that transition to `Exceeded` only when spending > budget amount. Without this, the diagram would allow invalid overspending states. Writing clear, concise guards was challenging but necessary for accuracy.

### 3. Aligning with Agile User Stories
Each state diagram had to trace back to functional requirements from Assignment 4 and user stories from Assignment 6. For instance, the `Alert` object lifecycle directly supports US-F08 (receive budget alert). I had to revisit my earlier work to ensure consistency, which took time but reinforced traceability.

### 4. Designing Activity Diagrams with Swimlanes
Swimlanes clarify responsibility (user vs system). The challenge was deciding when to split actions into parallel flows. In the `Export CSV` diagram, I used parallel actions for file generation and logging because they are independent. In other workflows like `Add Expense`, budget alert checking runs after saving, but I kept it sequential to avoid overcomplicating the diagram.

### 5. Balancing Detail vs. Readability
Activity diagrams for workflows like `Receive Budget Alert` (background monitoring) are not linear. I had to represent a continuous loop (monitor spending) with a decision branch. The Mermaid syntax for loops is limited, so I used an `alt` block to show the monitoring path. This was a trade-off between perfect UML compliance and practical readability.

### 6. Comparing State Diagrams vs Activity Diagrams
State diagrams focus on **object lifecycles** – how a single entity (e.g., an Expense) changes over time in response to events. Activity diagrams focus on **process flows** – the sequence of actions performed by actors to achieve a goal. I initially confused the two: I tried to put user actions inside state diagrams. Learning the distinction was valuable. State diagrams answer "what states can this object be in?" while activity diagrams answer "how do we complete this task step by step?"

## Lessons Learned

- **State granularity matters:** Too many states confuse; too few miss critical behaviour.
- **Guard conditions prevent illegal transitions:** They are essential for robustness.
- **Swimlanes improve clarity:** They show who does what in a workflow.
- **Parallel actions speed up processes:** Identifying concurrency (e.g., logging while generating CSV) optimises design.
- **Traceability is non‑negotiable:** Every diagram must link to a requirement or user story.

## Conclusion

This assignment deepened my understanding of dynamic system behaviour. State diagrams helped me think about object lifecycles, while activity diagrams visualised end‑to‑end processes. Together, they bridge the gap between static requirements and executable design.
