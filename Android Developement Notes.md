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


#### Fragment Lifecycle
![fragmentLifeCycle](/fragment-view-lifecycle.png)

I'd be glad to explain companion objects in Kotlin:

**Companion Objects in Kotlin**

In Kotlin, a companion object is a special type of object that's closely associated with a class. It allows you to define members (functions, properties) that can be accessed without creating an instance of the class itself. This is similar to the concept of static members in other languages like Java, but with some key differences.

**Key Characteristics:**

- **Declared within a class:** You define a companion object using the `companion object` keyword inside a class declaration.
- **Singleton instance:** The Kotlin compiler guarantees there will be only one instance of the companion object for the entire class.
- **Access using class name:** You can access the companion object's members directly using the class name, without needing an object reference.

**Use Cases for Companion Objects:**

- **Factory methods:** Companion objects are commonly used to create factory methods that provide a convenient way to instantiate the class. For example:

```kotlin
class User {
    companion object Factory {
        fun create(name: String, email: String): User {
            return User(name, email)
        }
    }
}

val user1 = User.Factory.create("Alice", "alice@example.com")
```

- **Utility functions:** Companion objects can hold utility functions related to the class that don't require an object instance. For instance:

```kotlin
class MathUtils {
    companion object {
        fun add(x: Int, y: Int): Int {
            return x + y
        }
    }
}

val sum = MathUtils.add(5, 3) // Access using class name
```

- **Constants:** Companion objects are suitable for defining constants associated with the class:

```kotlin
class NetworkConfig {
    companion object {
        const val BASE_URL = "https://api.example.com"
    }
}

val url = NetworkConfig.BASE_URL
```

**Advantages of Companion Objects:**

- **Improved code readability:** By keeping utility functions and constants related to the class within the companion object, you enhance code organization and maintainability.
- **Singleton-like behavior:** Companion objects provide a single instance for utility functions and constants, ensuring consistency across the application.

**Key Differences from Java Static Members:**

- **Not a direct equivalent:** While companion objects offer similar functionality to static members, they aren't a perfect one-to-one mapping. Companion objects can inherit from other classes or implement interfaces, which isn't possible with Java static members.
- **Focus on object-oriented design:** Kotlin emphasizes object-oriented principles, and companion objects are designed to complement that approach.

In essence, companion objects provide a clean and object-oriented way to define class-level functionality and constants in Kotlin, promoting better code organization and maintainability.

- From static context, you cannot access instance context.
- From Instance Context, you can access the static context.

### Tab Navigation
- [ViewPager](https://developer.android.com/reference/kotlin/androidx/viewpager2/widget/ViewPager2) Swipe views let you navigate between sibling screens, such as tabs, with a horizontal finger gesture, or swipe. This navigation pattern is also referred to as horizontal paging. 
  - Try [View Pager 2](https://developer.android.com/develop/ui/views/animations/screen-slide-2) here
- [TabLayout](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout) TabLayout provides a horizontal layout to display tabs.

Population of the tabs to display is done through TabLayout.Tab instances. You create tabs via newTab(). From there you can change the tab's label or icon via TabLayout.Tab.setText(int) and TabLayout.Tab.setIcon(int) respectively. To display the tab, you need to add it to the layout via one of the addTab(Tab) methods.

**Explore NavigationDrawer, BottomNavigation & UpNavigation**

**Fragments do not handle the back stack by default**

#### Navigation Components in Android
Navigation refers to the interactions that let users navigate across, into, and back out from the different pieces of content within your app.

Android Jetpack's Navigation component includes the Navigation library, Safe Args Gradle plug-in, and tooling to help you implement app navigation. The Navigation component handles diverse navigation use cases, from straightforward button clicks to more complex patterns, such as app bars and the navigation drawer.

[Learn More here](https://developer.android.com/guide/navigation)

**Learn the navigation components here**
![Navigation Components](/nav_comps.png)

[Youtube video](https://youtu.be/NqpyCKlYLVU)

#### Public APIs
A list of APIs that can fetch you data in various categories. 
[Link](https://github.com/public-apis/public-apis)

JSON - Java script Object Notation

Access the slide deck for [AsyncTask](https://docs.google.com/presentation/d/1A7anDTS8NQCunbxoJnqJqkSHNFCvRIn9moE7Zww-gds/edit#slide=id.g116d7d9d49_3_13)

### Using Volley Library to do networking in android

Library that we are going to use : [Google Books](https://developers.google.com/books)

[Volley Documentation](https://google.github.io/volley/)

### GSON Library
This library seralizes and de-serializes the java objects to json and vice-versa. 

[Link](https://github.com/google/gson?tab=readme-ov-file)

Use this [link](https://json2kt.com/) to convert the json data to kotlin classes directly by just taking the json response.

### Image Loading library
[link](https://github.com/bumptech/glide)

**Retrofit**: Networking library for android

[Official Link](https://square.github.io/retrofit/)

**Volley vs retrofit**

**Volley**  
***Pros***
- **Simplicity:** Easy to use and integrate into android projects. 
- **Built-In-Features**:Automatic scheduling of Network requests, Multiple concurrent network connections, Caching is also in place.
- **Out of the Box Support**: Volley works well for small to medium-sized applications. 

***Cons***
- **Scalability**: Can be less efficient for large-scale applications or complex data structures
- **Customization**: Limited in terms of customization and flexibility in comparision with Retrofit.
- **Error Handling**: can be less intuitive. 

**Retrofit**  
***Pros***
- **Flexibility**: Highly customizable and can handle complex APIs easily. 
- **Efficiency**: Uses OkHttp for efficient network operations
- **serialization**: Supports various serialization libraries (Gson, Moshi, Protobuff...)
- **Type Safety**: Strongly types interfaces, which make code more robust and easier to debug. 
- **RxJava Support**: to write reactive programming (publish-subscribe pattern).
- **Error Handling**: More advanced and intutive error handling

***Cons***
- **Learning Curve**: More complex to set up and requires a bit more intial configuration. 

### GET request using Retrofit

#### Step 1:
Add `INTERNET` Permission in the `android_manifest.xml`
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

#### Step 2:
Add the dependencies `build.gradle(Module:app)`

```groovy
implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
```

#### Step 3:
Create a model class (Data class) to match the json response that is returned when the url is run.

`Model Class`
```kotlin
package com.nareshit.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serial
// TODO 3
data class FakeGet(
    @SerializedName("userId") var userId:Int? = null,
    @SerializedName("id") var id:Int? = null,
    @SerializedName("title") var title:String? = null,
    @SerializedName("body") var body:String? = null
)
```

We are creating this model class for the following json data that will be returned when the "https://jsonplaceholder.typicode.com/posts/1" is run

```json
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

#### Step 4:
Create a kotlin interface to maintain all the kinds of requests that you want to perform. Create individual methods (abstract) to perform each request kind. 

```kotlin
package com.nareshit.retrofit

import retrofit2.Call
import retrofit2.http.GET

// TODO 4
interface JsonTypicodeInterface {

    @GET("posts/1")
    fun getData(): Call<FakeGet>
}
```

#### Step 5:
Create a retrofit object as shown below by adding your own choice of converter factory.
This code usually goes in `activity`, `service` or `fragment`.

```kotlin
val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
jsonTypicodeInterface = retrofit.create(JsonTypicodeInterface::class.java)
```

#### Step 6:
perform the request

```kotlin
jsonTypicodeInterface?.getData()?.enqueue(object: Callback<FakeGet>{
            override fun onResponse(p0: Call<FakeGet>, p1: Response<FakeGet>) {
                val posts = p1.body()
                Log.v("MAIN",posts.toString())
            }

            override fun onFailure(p0: Call<FakeGet>, p1: Throwable) {

            }
        })
```

### Perform a POST request

#### Step 1:
Create a model class to match your request json data.

```json
{
    title: 'foo',
    body: 'bar',
    userId: 1,
}
```

```koltin
package com.nareshit.retrofit

data class PostRequest(val title:String, val body:String, val id:Int)
```

#### Step 3:
you will get the json data from the post url, you need to create a model class (Data class) to match the data that you get

```Json
{
  id: 101,
  title: 'foo',
  body: 'bar',
  userId: 1
}
```

```kotlin
package com.nareshit.retrofit

data class PostResponse(val id:Int, val title:String, val body:String, val userId:Int)
```

#### Step 4:
Create a method for post request in the interface.

```kotlin
package com.nareshit.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// TODO 4
interface JsonTypicodeInterface {

    @GET("posts/1")
    fun getData(): Call<FakeGet>

    @POST("posts")
    fun postData(@Body postRequest: PostRequest):Call<PostResponse>
}
```

#### Step 5:
Write post method

```kotlin
jsonTypicodeInterface?.postData(PostRequest("Pavan","Trainer", 100))?.enqueue(object:Callback<PostResponse>{
            override fun onResponse(p0: Call<PostResponse>, p1: Response<PostResponse>) {
                Log.d("MAIN",p1.body().toString())
            }

            override fun onFailure(p0: Call<PostResponse>, p1: Throwable) {

            }
        })
```

#### Assignment

Get the google books data after the user entering the book the user wants to search using retrofit library.

### Notifications in Android
Notifications are messages that gets displayed outside the regular app UI. 
Notificaitons are very important to keep up the user engagement with the application.

1. [Official Documentation](https://developer.android.com/develop/ui/views/notifications)

2. [Slides - Google Training team](https://docs.google.com/presentation/d/1Ch8DeXY5D2xpZ5248x_X-_2eycRW7emzdSHMur32Dg0/edit#slide=id.g116d7d9d49_3_13)

[Try Media Notifications](https://developer.android.com/reference/android/app/Notification.MediaStyle)

### Broadcast Receivers
Android Operating system releases a signal in the device so that other applications can receive the signals and perform certain kind of an action. This is called Broadcasting. 

**What kind of Signals get released in the android system ?**
Almost all things that happen in the android system has some kind of significance such as AIRPLANE_MODE_CHANGED, POWER_CONNECTED, POWER_DISCONNECTED, HEADSET_PLUG_IN, BOOT_COMPLETED...

**Broadcasts**
- System Generated Broadcasts
- App generated Broadcasts (Custom Broadcasts)

**Registering for a broadcast**
- Static registration - where we use manifest file to register for the broadcast
- Dynamic registration - this happens when the code is run
  
from API level 26 (Oreo), most of the broadcasts are excempted from static registration. 

See the list of broadcasts that can be registered statically here in this [link](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions#:~:text=As%20part%20of%20the%20Android,are%20exempted%20from%20these%20limitations.)

### [Alarm Manager](https://docs.google.com/presentation/d/1Xz5TVqIsKWR2J1-OdZHrSh3mE52AIAWeVhhVNkVdnQE/edit#slide=id.g18e5d42159_0_330)

### JobScheduler
An Intelligent Scheduling algorithm.

Three components
- JobService
  - Where you define the task to execute
  - Remember that these methods are called by the android operating system when the conditions defined in JobInfo meets.
  - onStartJob(...):Boolean 
    - True: When the task is been off-loaded to a worker thread 
    - False: When the task is finished
  - onStopJob(...):Boolean
    - True: When the job that is stopped in between its execution is supposed to be re-scheduled.
    - False: when the job that is stopped in between its execution need not be re-scheduled.
- JobInfo
  - Where you will be defining the conditions
- JobScheduler
  - Which actually schedules a task to complete

[Official Documentation](https://developer.android.com/reference/android/app/job/JobScheduler)

[Presentation Link](https://docs.google.com/presentation/d/1jWZ10wsLZTPhTl2jcPpa-PpkIbfJAeoVKfUv-eQoSCk/edit#slide=id.g18e75634d0_0_172)


### Work Manager
- This is an advanced library than JobSchduler
    
    WorkManager is the recommended solution for persistent work. Work is persistent when it remains scheduled through app restarts and system reboots. Because most background processing is best accomplished through persistent work, WorkManager is the primary recommended API for background processing.

WorkManager handles three types of persistent work:

**Immediate**: Tasks that must begin immediately and complete soon. May be expedited.

**Long Running**: Tasks which might run for longer, potentially longer than 10 minutes.

**Deferrable**: Scheduled tasks that start at a later time and can run periodically.

![Image](/wm.svg)

Type|	Periodicity	|How to access
----|---------------|-------------
Immediate|One time|OneTimeWorkRequest and Worker.For expedited work, call setExpedited() on your OneTimeWorkRequest.
Long Running|One time or periodic|Any WorkRequest or Worker. Call setForeground() in the Worker to handle the notification.
Deferrable|	One time or periodic|	PeriodicWorkRequest and Worker.

[Official Documentation](https://developer.android.com/topic/libraries/architecture/workmanager)

[Building the work manager](https://developer.android.com/develop/background-work/background-tasks/persistent/getting-started/define-work#work-constraints)

### Shared Preferences 
[Official Document](https://developer.android.com/training/data-storage/shared-preferences)

If you have relatively small amount of data to be stored and used in the application, we use SharedPreferences


### SQLite Database in android
SQL -> Structured Query Language  
SQlite is a database (that's based on file) for android.   
All the Basic SQL Queries run smoothly on Android   
Do not store huge data - keep in mind the device constraints.  

Practice Queries on [SQLiteOnline.com](https://sqliteonline.com/)

Practice the following queries on SQLiteOnline.com
- Create
- insert
- delete
- drop
- update

[refer](/SQL%20queries.MD)

- SQLiteOpenHelper - this is a class that helps us to manage the database transactions smoothly. 
- Two methods
  - onCreate(...) - The database gets created also the tables.
  - onUpgrade(...) - When there is a change in the schema of the database such as version upgrades and etc., this method gets invoked. 

### Content Providers in Android
An Application that provides data to another application is called "Content Provider". 

![image](/cp.png)

[Official Doc Link](https://developer.android.com/guide/topics/providers/content-provider-basics)

### View Binding
View binding is a feature that makes it easier to write code that interacts with views. ***Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module.*** An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.

***In most cases, view binding replaces findViewById.***

#### Set-Up

Go to your module level `build.gradle` file and add this code

```kotlin
android {
    ...
    buildFeatures {
        viewBinding = true
    }
}
```

[Official Document](https://developer.android.com/topic/libraries/view-binding#kts)

The Major advantages of using `Viewbinding` library is that we can avoid `boilerplate code`. Note that boilerplate code is not completely avoidable. 

What is `Boilerplate code`?
- In computer programming, boilerplate code, or simply boilerplate, are sections of code that are repeated in multiple places with little to no variation. When using languages that are considered verbose, the programmer must write a lot of boilerplate code to accomplish only minor functionality.

[Watch the playlist](https://youtu.be/OKKCPplPMeY)

### View Model
- An architecture component that is android jetpack libraries.

- The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.

### Live Data
LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

### Room Database
- Room is not separate database. It is based on SQLite only. But this is an abstract layer built on top of SQLite using ORM (Object Relational Mapping). This simplifies the use of Databses in your android apps. 

[Offical Docs](https://developer.android.com/training/data-storage/room)

#### Components in Room Databse
- Entity
  - Is a class in which you will represent the entire database table
  - class name = Table name
  - Variable names = coulumn names
- DAO (Database Access Object)
  - This is an interface and by declaring the methods, the SQL queries are auto created. 
- RoomDatabase
  - This is an entry abstract class where the database transactions can be started. 

### Firebase
- Firebase is a google prodct that offers multiple services such as Authentication, crashlytics, Remote Configuration, Real time databases and etc., Basically, firebase is a google cloud product. 

- You can sign in to firebase console by your gmail account. 

[Read about implementing Real time databases here](https://firebase.google.com/docs/database/android/start)

Try Adding data to the databases to firebase at home. also handle the error listener.

### Jetpack UI Compose
- Design your UI Screens without a need of creating XML file for layout.
- This gives us flexibility to manage the code related to UI and also the code related to business logic.
- Faster than XML
- Jetpack Compose is Android’s recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

[Official Documentation](https://developer.android.com/develop/ui/compose/documentation)

### Coroutines
Co - Cooperative  
Routines - Functions

#### Synchronous and Asynchronous programming

**Synchronous:** In Synchronous programming, tasks are executed sequentially. One Task must complete before the next one can start. this is like waiting in a single line queue. 

Example:

```Kotlin
fun synchronousExample(){
  val result1 = longRunningOperation1()
  var result2 = longRunningOperation2(result1)
  //...
}
```

**Asynchronous Proggramming:** In Asynchronous programming, tasks can run independently, without waiting for the previous one to finish. This is like having multiple lines in a queue. 

Example:

```kotlin
suspend fun asynchronousExample(){
  val result1 = async{longRunningCode1()}
  val result2 = async{longRunningCode2()}
  //...
}
```

**When to use which**

**Synchronous**: Suitable for simple tasks, short operations and when order of execution is critical. 

**Asynchronous**: Ideal for I/O bound operations (network calls, database queries, etc.,), long running tasks and when improving application resposiveness is important. 

---

Coroutines are a koltin feature that converts async callbacks for long-running tasks, such as network access, into sequential code. 

[Official Documentation](https://developer.android.com/kotlin/coroutines)

- If we have multiple long running tasks, you create multiple threads for each one of them. When there are multiple background threads, the system may run Out of Memory. we can create a single background thread and create multiple coroutines to perform the multiple background operations. By using memory that is required for running one single thread, we can handle multiple background tasks. 
- Light-Weight threads
- Like Threads, coroutines can run in parllel, wait for each other and communicate with each other
- coroutines!=Thread
- In terms of memory usage, coroutines are comparatively very cheap.
- You can create thousands of coroutines without any memory issues. 

**What are threads ?**
- Threads are used to execute concurrent tasks, allowing different parts of the program to run independently.
- class that can be used for thread is `Thread`.
- Threads allow for parllelism.
- They also help to perform async programming. 

```kotlin
package com.nareshit.coroutines

import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")
    thread {
        println("This line runs on:${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("This line runs on:${Thread.currentThread().name}")
    }
    println("Main Program Ends: ${Thread.currentThread().name}")
}
```

Note: Threads run in parallel. The program is not finished until your thread finishes its job. 

#### Coroutine example
```kotlin
package com.nareshit.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")
    GlobalScope.launch {
        // This is where you can run a coroutine
        println("coroutine 1 starts: ${Thread.currentThread().name}")
        delay(1000)
        println("coroutine 1 ends: ${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        // This is where you can run a coroutine
        println("coroutine 1 starts: ${Thread.currentThread().name}")
        delay(1000)
        println("coroutine 1 ends: ${Thread.currentThread().name}")
    }

    Thread.sleep(2500)
    println("Main Program Ends: ${Thread.currentThread().name}")
}
```

**delay() vs Thread.sleep()**

Thread.sleep(1000) -> Block the Thread for 1 second. Now, the thread gets lazy.

delay(1000) -> This should only be written in coroutine context. Only suspends the coroutine for 1 second. This is not going to block the thread at all. Other coroutines that are running can be in running state while the current coroutine is suspended for a second. 

#### Suspend modifier
- A function with `suspend` modifier is known as suspending function.
- A suspending function can only be called from a coroutine context or from another suspending function. 
- delay(...) is also a suspending function.

Now, you want to block the main thread using a coroutine.

```kotlin
runBlocking{// this creates a coroutine that can block the thread on which it is running
  delay(3000)
}
```

#### Three Coroutine Builders
1. Launch 
    - This is a coroutine that does not return anything
2. async
    - This coroutine returns a deferred object
3. runBlocking
    - This coroutine builder blocks the ui thread.

#### Dispatchers
These dispatchers define where your coroutine has to run 
- Dispatchers.Main - Lets you run the coroutine on the Main thread
- Dispatchers.IO - Let's you run the coroutine in a separate thread. 
- Dispatchers.Default - For CPU Intensive tasks, you use this thread to run your coroutine. 

***Your coroutine's dispatcher will be defined by the scope***

### Services in Android

A Service is an application component that can perform long-running operations in the background. It does not provide a user interface. Once started, a service might continue running for some time, even after the user switches to another application. Additionally, a component can bind to a service to interact with it and even perform interprocess communication (IPC). For example, a service can handle network transactions, play music, perform file I/O, or interact with a content provider, all from the background.

***A service runs in the main thread of its hosting process; the service does not create its own thread and does not run in a separate process unless you specify otherwise.***

### Three Types of Services
- ***Foreground service:*** A Kind of service that notifies the user about its running through a notification. 
  - When you use a foreground service, you must display a notification so that users are actively aware that the service is running. This notification cannot be dismissed unless the service is either stopped or removed from the foreground.
- ***Background Service:*** A background service performs an operation that isn't directly noticed by the user. For example, if an app used a service to compact its storage, that would usually be a background service.

- ***Bound Service:*** A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even do so across processes with interprocess communication (IPC).

[Official Documentation](https://developer.android.com/develop/background-work/services)

***Service Lifecycle:***
![Image](/service_lifecycle.png)

***onStartCommand()***

The system invokes this method by calling startService() when another component (such as an activity) requests that the service be started. When this method executes, the service is started and can run in the background indefinitely. If you implement this, it is your responsibility to stop the service when its work is complete by calling stopSelf() or stopService(). If you only want to provide binding, you don't need to implement this method.

***onBind()***

The system invokes this method by calling bindService() when another component wants to bind with the service (such as to perform RPC). In your implementation of this method, you must provide an interface that clients use to communicate with the service by returning an IBinder. You must always implement this method; however, if you don't want to allow binding, you should return null.

***onCreate()***

The system invokes this method to perform one-time setup procedures when the service is initially created (before it calls either onStartCommand() or onBind()). If the service is already running, this method is not called.

***onDestroy()***

The system invokes this method when the service is no longer used and is being destroyed. Your service should implement this to clean up any resources such as threads, registered listeners, or receivers. This is the last call that the service receives.

[Media Player in Android](https://developer.android.com/media/platform/mediaplayer)

### Types Of Location Access
- Allow Only while using the app
  - Also Known as While in use or Foreground only access.
  - Added in the android 10
- Allow One-time
- Allow All time (Your app needs to be complient with the google location policies)
- Deny

***Location Providers***
- NETWORK_PROVIDER 
  - request a permission to the user (ACCESS_COARSE_LOCATION)
- GPS_PROVIDER
  - Request the permission to the user (ACCESS_FINE_LOCATION)

Your app can access the set of supported location services through classes in the `com.google.android.gms.location` package. 

Lets take a look at the main classes

***FusedLocationProviderClient***

- This class is the central component of the location framework. Once created, you use it to request location updates and get the last known location. 

***LocationRequest***

- This is a data object that contains quality of service parameters for requests (intervals of updates, priorities and accuracy)
- This is passed to the `FusedLocationProviderClient` when you request location updates.

***LocationCallback***

- This is used for receiving notifications when the device location has changed or can no longer be determined. 
- This is passed to `LocationResult` when you can get the `Location` to save in your database. 

Use this APi key for testing
`AIzaSyAU_DMRbCLn23RKD2FCa27eQoFwRk8QRLk`

Use it for just testing. 

