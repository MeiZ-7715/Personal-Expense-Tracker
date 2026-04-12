# Template Analysis and Selection – Personal Expense Tracker

This document evaluates GitHub's project templates and justifies the selection for managing the Personal Expense Tracker development.

## Template Comparison Table

| Feature | Basic Kanban | Automated Kanban | Bug Triage |
|---------|--------------|------------------|-------------|
| **Default Columns** | To do, In progress, Done | To do, In progress, Done | Needs triage, High priority, Low priority, Closed |
| **Automation** | None – manual card movement only | Cards move automatically when issues are opened/closed or PRs are merged | Basic automation for closing issues |
| **Best For** | Simple task tracking, small personal projects | Teams wanting to reduce manual updates, sprint-based work | Bug tracking and prioritisation |
| **Agile Suitability** | Good for basic Kanban | Excellent for Scrum + Kanban hybrid | Good for defect management |
| **Workflow Visibility** | Manual status updates required | Real-time status updates from repo activity | Focus on priority-based triage |
| **Setup Complexity** | Very simple | Simple | Simple |

## Selected Template: Automated Kanban

I have chosen the **Automated Kanban** template for the Personal Expense Tracker project.

### Justification

**1. Alignment with Agile Methodology:**
The Automated Kanban template supports continuous delivery and adaptability, which are core Agile principles. As a solo developer, I need to focus on coding rather than manually moving cards. Automation reduces overhead and keeps the board honest.

**2. Real-time Status Tracking:**
When I close an issue or merge a pull request, the card automatically moves to the "Done" column. This provides accurate, up-to-date visibility of project progress without extra effort.

**3. Sprint Support:**
The template works perfectly with the sprint planning I did in Assignment 6. Issues created for each user story will automatically appear in the "To do" column, ready for the sprint.

**4. Scalability:**
While I am working alone now, the Automated Kanban board can easily accommodate additional team members in the future. The automation features become even more valuable with multiple contributors.

**5. Comparison with Other Templates:**
- **Basic Kanban** requires manual card movement. This would add unnecessary friction and increase the risk of the board becoming outdated.
- **Bug Triage** is designed for defect management, not feature development. My project has few bugs at this stage, so this template is not suitable.

Therefore, the **Automated Kanban** template is the optimal choice for managing the Personal Expense Tracker development workflow.
