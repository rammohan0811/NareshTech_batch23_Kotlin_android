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

