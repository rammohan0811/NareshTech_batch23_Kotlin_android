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

### Intents in Android
An Intent is a messaging object you can use to request an action from another app component. Although intents facilitate communication between components in several ways, there are three fundamental use cases:

- Start Activity
- Deliver a Broadcasts
- Start Service

There are two types of intents:

**Explicit intents** specify which component of which application will satisfy the intent, by specifying a full ComponentName. You'll typically use an explicit intent to start a component in your own app, because you know the class name of the activity or service you want to start. For example, you might start a new activity within your app in response to a user action, or start a service to download a file in the background.  

**Implicit intents** do not name a specific component, but instead declare a general action to perform, which allows a component from another app to handle it. For example, if you want to show the user a location on a map, you can use an implicit intent to request that another capable app show a specified location on a map.

