# Template Analysis and Selection – Personal Expense Tracker

This document evaluates GitHub's current project templates and justifies the selection for managing the Personal Expense Tracker development.

## Template Comparison Table

| Feature | Kanban | Iterative Development | Bug Tracker |
|---------|--------|----------------------|-------------|
| **Default Columns** | To do, In progress, Done | Backlog, Iteration, In progress, Review, Done | Triage, High priority, Low priority, Closed |
| **Automation** | None – manual card movement | Cards auto-move when issues are closed or PRs merged | Basic automation for closing issues |
| **Best For** | Simple task tracking, small personal projects | Sprint-based work with iteration planning | Bug tracking and prioritisation |
| **Agile Suitability** | Good for basic Kanban | Excellent for Scrum + Kanban hybrid | Good for defect management |
| **Workflow Visibility** | Manual status updates required | Real-time updates from repo activity | Focus on priority-based triage |
| **Setup Complexity** | Very simple | Simple | Simple |

## Selected Template: Iterative Development

I have chosen the **Iterative Development** template for the Personal Expense Tracker project.

### Justification

**1. Alignment with Agile Methodology:**
The Iterative Development template is designed for sprint-based work, which matches the sprint planning I did in Assignment 6. It includes a "Backlog" column for unscheduled work and an "Iteration" column for current sprint items.

**2. Automation Features:**
This template automatically moves cards when issues are closed or pull requests are merged. This reduces manual updates and keeps the board accurate – essential for a solo developer.

**3. Built-in Review Column:**
The "Review" column encourages code review before completion, which aligns with quality assurance needs.

**4. Comparison with Other Templates:**
- **Kanban** template has no automation and only three columns. It would require too much manual work.
- **Bug Tracker** is designed for defect management, not feature development. My project has few bugs at this stage.

Therefore, the **Iterative Development** template is the optimal choice for managing the Personal Expense Tracker development workflow.
