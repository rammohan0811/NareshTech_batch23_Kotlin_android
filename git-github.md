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





