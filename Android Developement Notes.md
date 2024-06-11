### What is Gradle ?
Gradle is a build automation tool that is used extensively in android development. 
- It basically handles the tasks of compiling, linking, packaging and managing dependencies for android applications.

#### Key Concepts
1. **Build Scripts:** Gradle uses Groovy or Kotlin DSL (Domain Specific Language) to define build scripts. There are a few main scripts that are used in android projects
   1. **Top-Level build.gradle file :** Located at the root of the project. This file is used to define project-wide configurations and dependencies.
   2. **Module-Level build.gradle file:** Located in each module's directory.This file is used to define  module-specific configurations, dependencies and build tasks.
2. **Gradle Wrapper:** This ensures that the project uses a specific version of gradle, providing consistency across different environments. The wrapper consists of files like gradlew, gradlew.bat and the gradle/wrapper directory.

#### Advantages
1. Flexibility
2. Dependency Management
3. Build Variants
4. Incremental Builds
5. Extensibility

