# Reflection – Open Source Collaboration (Assignment 14)

## How I Improved the Repository Based on Peer Feedback

After sharing my repository with classmates, I received several suggestions. One common comment was that the setup instructions were buried in the README. I moved them to a prominent "Getting Started" section and added a clear prerequisites list. Another peer noted that the contribution process was not obvious, so I created a detailed `CONTRIBUTING.md` with step‑by‑step instructions for forking, branching, and submitting PRs. I also added a "Features for Contribution" table to help newcomers quickly identify tasks that match their skill level.

Some classmates wanted to see future plans, so I wrote `ROADMAP.md` with short‑term and long‑term features. This gives contributors a sense of direction. I also labelled issues as `good-first-issue` and `feature-request`, making it easier for people to pick work that suits them.

## Challenges in Onboarding Contributors

The biggest challenge was balancing simplicity with completeness. I wanted to make the setup easy, but the project requires Java 17, Maven, and a few dependencies. Writing instructions that work for both Windows and Linux was tricky – I ended up using generic commands that work on any platform.

Another challenge was predicting what new contributors would struggle with. For example, I initially forgot to mention that they need to run `mvn test` before starting to code. A peer pointed this out, and I added that step to `CONTRIBUTING.md`.

I also worried about issue labelling: too many `good-first-issue` tasks could be too trivial; too few would discourage beginners. I settled on five simple issues (typo fixes, test improvements) and three larger feature requests. This seems to work well.

## Lessons Learned About Open‑Source Collaboration

This assignment taught me that open source is not just about writing code – it is about communication, documentation, and empathy. A well‑maintained `README.md` and `CONTRIBUTING.md` are as important as the code itself. Clear issue labels and a roadmap show contributors that their work is valued and that there is a plan.

I also learned that stars and forks are not just vanity metrics; they represent trust. When someone stars your repository, they are saying “this project is useful”. Forks indicate that someone wants to build on your work. Seeing even a few stars and forks motivated me to keep improving the project.

Finally, I understand now why open‑source projects have strict contribution guidelines. They save time in the long run by preventing chaos and ensuring consistency. I will definitely apply these practices to my future projects.
