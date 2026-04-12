# Kanban Board Explanation – Personal Expense Tracker

## What is a Kanban Board?

A Kanban board is a visual project management tool that helps teams visualise work, limit work-in-progress (WIP), and maximise efficiency. The name "Kanban" comes from Japanese, meaning "visual signal" or "card". It was originally developed by Toyota in the 1940s for manufacturing, but has been widely adopted in software development.

A Kanban board consists of:
- **Columns** representing different stages of work (e.g., "To Do", "In Progress", "Done")
- **Cards** representing individual tasks or user stories
- **Cards move from left to right** as work progresses

## How My Kanban Board Visualises Workflow

My custom Kanban board for the Personal Expense Tracker uses the following columns to visualise the workflow:

| Column | Purpose |
|--------|---------|
| **Backlog** | All user stories that have been identified but not yet scheduled for a sprint |
| **To Do** | Stories selected for the current sprint, ready to be worked on |
| **In Progress** | Stories currently being developed (limited to 3 at a time) |
| **Testing** | Stories that have been coded but need validation |
| **Blocked** | Stories that cannot proceed due to a dependency or issue |
| **Review** | Stories ready for final review before completion |
| **Done** | Completed stories that are fully tested and accepted |

This visual layout provides an instant snapshot of project health. I can see at a glance which tasks are active, which are stuck, and what has been completed.

## Work-in-Progress (WIP) Limits

To prevent bottlenecks and maintain focus, my board implements WIP limits:

| Column | WIP Limit | Rationale |
|--------|-----------|-----------|
| In Progress | 3 tasks | As a solo developer, working on more than 3 tasks simultaneously leads to context switching and reduced productivity |
| Testing | 2 tasks | Testing requires focused attention; too many tasks in testing indicates a bottleneck |
| Blocked | No limit | Blocked tasks need visibility, but they are not actively worked on |

These limits ensure that I finish tasks before starting new ones, which is a core Kanban principle.

## How the Board Supports Agile Principles

| Agile Principle | How My Kanban Board Supports It |
|----------------|--------------------------------|
| **Individuals and interactions** | The board clearly shows task assignments, facilitating communication if I were working in a team |
| **Working software** | The "Testing" and "Review" columns ensure that only completed, tested work moves to "Done" |
| **Customer collaboration** | The board is transparent; stakeholders can view progress at any time |
| **Responding to change** | Cards can be reprioritised or moved back to earlier columns if requirements change |
| **Continuous delivery** | The "Done" column provides a steady stream of completed work, ready for deployment |
| **Adaptability** | Columns can be added, removed, or renamed as the workflow evolves |
| **Focus on value** | The "Backlog" column allows prioritisation of the most valuable stories first |
| **Limit WIP** | Explicit WIP limits prevent overload and maintain flow |
| **Visualise workflow** | The entire development process is visible from idea to deployment |

## Conclusion

The Kanban board is not just a task list – it is a powerful tool for managing flow, identifying bottlenecks, and continuously improving the development process. For the Personal Expense Tracker, this board provides the structure needed to deliver a high-quality product efficiently.se Tracker, this board provides the structure needed to deliver a high-quality product efficiently.
