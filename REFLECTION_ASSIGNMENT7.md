# Reflection: Template Selection and Kanban Customisation – Assignment 7

## Challenges Faced

### 1. Choosing the Right Template

The most difficult decision was selecting between Basic Kanban and Automated Kanban. The Basic Kanban template is simpler and gives me full manual control. However, I realised that as a solo developer, I need to minimise administrative overhead. The Automated Kanban template moves cards automatically when issues are closed or pull requests are merged. This keeps the board accurate without extra work. The trade-off was accepting that I cannot control every card movement manually, but the benefits outweigh this limitation.

### 2. Deciding on Custom Columns

GitHub's default columns (To do, In progress, Done) are sufficient for very simple projects. However, for a software development project with testing and review stages, these three columns are insufficient. I added "Testing", "Blocked", "Backlog", and "Review" columns. The challenge was deciding how many columns to add – too many columns make the board cluttered, too few hide important workflow stages. I settled on 7 columns, which provides clear visibility without being overwhelming.

### 3. Setting WIP Limits

Determining the right Work-in-Progress limits required honest self-assessment. As a solo developer, I know I can only focus on 2-3 tasks at a time. I set the "In Progress" limit to 3. For "Testing", I set a limit of 2 because testing requires concentration and rushing leads to bugs. The "Blocked" column has no limit because blocked tasks are not actively being worked on, but they need visibility.

### 4. Linking Issues to the Board

The assignment requires linking GitHub Issues to the board. I had to create issues for each user story from Assignment 6 and ensure they were properly labelled. The challenge was maintaining consistency between the user stories document and the actual issues. I solved this by using the same story IDs (e.g., US-F01) in both places, ensuring traceability.

### 5. Comparing GitHub Projects to Other Tools

I researched alternative tools like Trello and Jira. Trello is simpler and has a cleaner interface, but it does not integrate with GitHub issues natively. Jira is more powerful but overkill for a solo project and has a steep learning curve. GitHub Projects strikes the right balance – it is free, integrates perfectly with my existing repository, and provides sufficient features for a project of this size.

## Lessons Learned

1. **Automation saves time.** The Automated Kanban template reduces manual updates, allowing me to focus on coding.

2. **WIP limits are essential.** Without limits, it is easy to start too many tasks and finish none.

3. **Customisation must be purposeful.** Every column added should serve a clear purpose in the workflow.

4. **Documentation matters.** The explanations in this document will help anyone who joins the project understand the workflow.

5. **GitHub Projects is a capable tool.** It is not just for code hosting; it is a legitimate project management platform.

## Conclusion

This assignment taught me that project management tools are not just about tracking tasks – they are about visualising workflow, identifying bottlenecks, and continuously improving. The Kanban board I created will serve as the command centre for the remainder of the project.
