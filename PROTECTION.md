# Branch Protection Rules – Personal Expense Tracker

## Why We Protect the `main` Branch

The `main` branch holds the production‑ready version of the code. Protecting it ensures:

- **Code quality** – every change must be reviewed by at least one person.
- **Automated testing** – all tests must pass before merging.
- **No direct pushes** – prevents accidental broken commits.
- **Full traceability** – all changes go through pull requests.

## Our Branch Protection Settings

| Setting | Value |
|---------|-------|
| Require pull request reviews | ✅, 1 approver |
| Require status checks | ✅ `Run Tests` (our GitHub Actions job) must pass |
| Dismiss stale reviews | ✅ |
| Restrict direct pushes to `main` | ✅ (only via PR) |

## How This Helps the Team

- **Quality** – Buggy code never reaches `main`.
- **Collaboration** – Encourages peer reviews and knowledge sharing.
- **Confidence** – CI tests give everyone confidence before merging.
- **History** – Every merge is documented in the pull request.

