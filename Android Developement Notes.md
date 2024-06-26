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

### Material Design Library
- Design library by google
- Lot of guidelines used to make your designs look splendid. 
- Follow [this link](https://m3.material.io/) to learn more
- Explore [the github page](https://github.com/material-components/material-components-android/tree/master/docs/components) for using the components directly.

### How to create a new Activity (Screen) ?
![Process](/image1.png)
![Next Step](/image2.png)

#### Starting an Activity for Result
1. Define the ActivityResultLauncher
   1. **ActivityResultLauncher** variable in your activity or fragment should be created. You will also need to define the callback that will handle the result from the launched activity.
2. Register the Launcher
   1. Register the launcher in the onCreate method.
3. Launch the Activity
   1. Use the launch(...) method to start the activity
4. Handle the result

[Refer to Official Doc](https://developer.android.com/training/basics/intents/result)

### Implicit Intents (Common Intents)
General purpose intents that we use. 
Examples:
1. You want to open a link in the default browser
2. You want to show a certain location to your users on Google Maps
3. You want to dail a friend from your application.
4. you want to open contacts app to pick a contact. 

[Refer to the official documentation](https://developer.android.com/guide/components/intents-common)

##### Assignment
Work with two more common intents
(Open a browser with a link)

### Constraint Layout In Android
[Official Documentation Link](https://developer.android.com/develop/ui/views/layout/constraint-layout)

[Excellent Codelab for Constraint Layout](https://developer.android.com/codelabs/constraint-layout#0)

### ListView
- ListView is a legacy view that helps us to display data in a list. 
- [official Documentation link](https://developer.android.com/reference/android/widget/ListView)

### Recyclerview
- Recyclerview is an advanced viewgroup to display large data in an efficient yet performant way.

[Official Documentation](https://developer.android.com/develop/ui/views/layout/recyclerview)

[Slides Link(By Pavan)](https://docs.google.com/presentation/d/1nFJqH0OSSZmjaycRzEGE6vvsm6jlxghQyoO15KKbkwc/edit#slide=id.p)

#### Assignment
Create a Favorite Destinations application where, you display the top 20 of your favorite destinations on the recyclerview as follows. 

![Image](/ass_img.png)

### Fragments 
A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. They must be hosted by an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.

[Official Link](https://developer.android.com/guide/fragments)

#### Create a Fragment
