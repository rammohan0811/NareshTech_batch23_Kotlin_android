### Resources for Git
- [Official Documentation Link](https://git-scm.com/)
- [Official E-Book](https://git-scm.com/book/en/v2)
### Resources for GitHub
- [Github Cheat sheet](https://education.github.com/git-cheat-sheet-education.pdf)
### Resources for Markdown Syntax
- [Cheat Sheet Link](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

### Git
- Git is a Source Code Management and Version control tool
- Developed by Linus torvals (man behind linux kernel).
  
### What is the importance ?
While you develop software, it is important that you have capability to roll back and forth the changes that you made to the software. To do this, you need to employ some kind of version control system in place. 

### Two Major Version Control systems 
- Centralized Version Control System
  - Internet Dependency
  - No Second option other than relying on the central server
- Distributed Version Control System
  - No Internet Dependency to carry out your work
  - Even If central server crashes, You still have local repositories to fetch back your code

Git is a distributed version control system.

### How to set up git ?
- Go to https://git-scm.com and hit on download button. 

### Repository
- A Git Repository is a central storage location for managing & tracking changes in files and directories. 
- It is a crucial component of the git version control system.

#### Set up the user-email & user-name
- git config --global user.name "Your Name"
- git config --global user.email "yourEmail@id.com"

#### Check what user name and email are set up
- git config user.email
- git config user.name
  
#### Initialize a new repository
- git init

***Two steps to remember when you make a commit (Saving a version in the repository)***
1. What ever the files you want to save as a version, move them to staging area
   1. git add <filename>
   2. git add <filename1> <filename2> <filename3>...
   3. git add .
2. Move the staging area files as a version into the repository
   1. git commit -m "Mention why you save this version"

##### Check the current status of your repo
- git status

This gives you the info about how many files are already saved as a version, how many files are untracked & How many files are been modified. 

##### Remove the staged files
- git rm --cached filename
- git rm --cached filename1 filename2

##### You can check the individual versions and why they are saved as a version in repository
- git log
  - 40 character length unique SHA(Secure hash algorithm) key
  - You will also have commit message
  - Who made the commit at what time info

- git log --oneline
  - Get all commits info in one single line
  - it has commit id and commit message.

- git log --oneline --reverse

### Switch among versions
- git checkout <Comit id>
- git checkout master

#### Branching
Suppose you want to develop a module in a project with out disturbing the existing code. Because you don't know how the new module is going to effect the output. Hence, it is recommended that you work on a separate branch. Once you are confident that the changes that you made is not effecting the output negatively, you can merge the changes back to the master branch. 

By default, all the repositories consists of a branch called master. 

![Notes](/branching.webp)

***Check how many branches are there***

- git branch

***How to create a new branch ?***

- git branch branch_name

By creating a new branch, you are making a commit. Along with that, you also get the code existing on the current branch.

***Switch to another branch***
- git switch branch_name

***Merge back a branch to another branch***
- Switch the branch into which you want to merge the immediate branch
- git switch branch

- You can merge
- git merge branch_name

**Note**: Merging a branch into another branch will not delete the branch.

***delete a branch***

- git branch -d branch_name

### GitHub

GitHub is a popular platform among developers for software development. Here's a breakdown of its key features:

* **Version control:**  Imagine you're writing a piece of code and keep making changes to it. With GitHub, you can track these changes and revert to older versions if needed. This functionality is powered by Git, a version control system.

* **Collaboration:**  GitHub allows developers to work together on projects.  Multiple people can work on the same codebase simultaneously, seeing each other's changes and merging them smoothly.

* **Code sharing:**  GitHub lets developers share their code publicly or privately. Public repositories are a great way to showcase your work, contribute to open-source projects, and learn from others' code.

* **Social networking:**  GitHub is a social network for developers. You can follow other developers, see their projects, and contribute to discussions. This is a great way to connect with other programmers and learn new things.

* **Additional features:**  Beyond core functionalities, GitHub offers features like project management tools, wikis for documentation, and security options.

In essence, GitHub is a one-stop shop for developers to build software collaboratively. If you're interested in learning more, you can search for  "What is GitHub" [https://www.youtube.com/github](https://www.youtube.com/github).

**Step 1**: Create an account on [GitHub](https://github.com)

**Step 2:** Creating a repository  
**Step 3:** Add a remote in an existing repository (Local)  
Check the remotes available
- git remote

Add a remote
- git remote add var_name url
- git remote add pavan https://github.com/tadipavankumarreddy/git-practice-batch-23.git

**Step 4:** Push the changes
- git push pavan master

**How do you pull changes ?**
- git pull pavan master
