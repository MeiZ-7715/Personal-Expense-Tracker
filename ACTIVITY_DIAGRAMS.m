
```markdown
# Activity Diagrams – Personal Expense Tracker

This document describes 8 complex workflows using UML activity diagrams. Swimlanes separate user and system actions. All amounts in ZAR.

## 1. User Registration Workflow

```mermaid
swimlane
    title User Registration
    actor User
    actor System
    User->User: Enter email & password
    User->System: Submit
    System->System: Validate email format & password strength
    alt valid
        System->System: Create account & send verification email
        System->User: Show success & auto-login
    else invalid
        System->User: Display error message
        User->User: Re-enter details
    end
