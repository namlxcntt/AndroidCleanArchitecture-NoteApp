----------
![This is an image](https://github.com/namlxcntt/NoteApp/blob/main/images/android-clean.png?raw=true)

# Android Clean Architecture - Kotlin

This repository wilk talk about applying [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) for Android developer. 

--------

The main principles in clean architecture will not be covered anymore in this article, here will mainly focus on applying clean architecture to building Android Application

---
# Clean Architecture
![This is an image](https://github.com/namlxcntt/NoteApp/blob/main/images/CleanArchitechture.png?raw=true)


-----
# Layers
![This is an image](https://github.com/namlxcntt/NoteApp/blob/main/images/Untitled.drawio.png?raw=true)

#### - Presentation: 
Presentation includes Android UIs (Activity, Fragment, View,etc...) and Android ViewModel class. View will display and receive interaction from the user. Communicate with other components through ViewModel

#### - Domain
Domain is excute business logic from datalayer and communicate data layer to presentation,Each task is considered a use case. Manager of use cases will be managed in the repository. Entities are defined separately, not in common use

#### - Data
Data will be the place to manage data sources. can be from network, database as well as devices memory
 
 ---
## Library
- Dependency Injection (DI): [Dagger Hilt](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- Database(SQLite - Room) : [Room](https://developer.android.com/training/data-storage/room)
- Language(Kotlin) : [Kotlin](https://kotlinlang.org/)
- Executes Asynchronously :[Kotlin Coroutines](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiA4KaRBhBdEiwAZi1zzrfte38ccz4Cv6bj_OGNL4KpQMa9HyaiZhW7z-StHJ7DQjK1OjDnHhoCLYwQAvD_BwE&gclsrc=aw.ds)
- Network(Retrofit): [Retrofit]("https://square.github.io/retrofit/") 
- Gradle(Kotlin) : [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- Testing(JUnit, Espresso,Hilt Testing)
- Image(Glide) : [Glide](https://github.com/bumptech/glide)
---
## Sample App
![This is an image](https://github.com/namlxcntt/NoteApp/blob/main/images/demo-app.gif?raw=true)
This is the notes app, which is the basic kind of app. Due to the limited time, the application has only 2 main functions, viewing the list of notes and creating notes, which are stored in Sqlite.
----
# Discussions
I hope that my knowledge will help everyone, for any problems and exchanges, please contact me via email: namlxcntt@gmail.com
