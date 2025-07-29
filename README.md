# GitHub User Search App

A sample Android application built with Kotlin that allows users to search for GitHub users and view user details. Built using modern Android development tools and follows MVVM architecture with a clean separation of concerns.

---

## Project Structure

```
com.mf.hcs.gitappusers
├── data
│   ├── api
│   │   └── GitHubApiService.kt         # Retrofit API interface for GitHub search
│   ├── repository
│   │   ├── GitHubRepositoryImpl.kt     # Implementation of repository logic (remote & local)
│   │   └── RepositoryModule.kt         # Hilt module for repository bindings
│   ├── domain
│   │   ├── model
│   │   │   ├── GitHubUser.kt           # Data model for GitHub user from API
│   │   │   └── SearchResponse.kt       # Response wrapper for user search
│   │   └── repository
│   │       └── GitHubRepository.kt     # Interface for repository (abstract layer)
│   ├── localdatabase
│   │   ├── dao
│   │   │   └── GitHubUserDao.kt        # Room DAO for GitHub user
│   │   ├── entity
│   │   │   └── GitHubUserEntity.kt     # Room entity
│   │   ├── AppDatabase.kt              # Room database
│   │   └── RoomModule.kt               # Hilt module for Room database
│   └── network
│       └── NetworkModule.kt            # Hilt module for Retrofit/OkHttp
├── search
│   ├── GitHubViewModel.kt              # ViewModel with LiveData & coroutine logic
│   └── UserAdapter.kt                  # RecyclerView Adapter for displaying users
├── ui
│   ├── MainActivity.kt                 # Search UI for GitHub users
│   ├── UserDetailActivity.kt           # Detail view for selected GitHub user
│   └── GitAppUsersApp.kt               # Application class with Hilt setup
```

---

##  Features
- **Search GitHub Users**  
  Type and search GitHub usernames using the GitHub REST API v3.

- **View User Details**  
  Click on a user to see their full profile: name, username, followers, etc.

- **MVVM Architecture**  
  Separation of concerns using ViewModel, Repository, and Data Sources.

- **Hilt Dependency Injection**  
  Easily inject ViewModel, API services, Room database, and repositories.

- **Room Persistence**  
  Save user data locally with Room for offline access.

- **Retrofit + OkHttp**  
  Efficient networking with logging for debugging.

- **GIF Loading Animation**  
  While fetching user data, the app displays a GIF animation from `res/raw/github_loading.gif`.


---

##  Tech Stack
### Core Tools
- **Kotlin 1.9.24**
- **Gradle Plugin 8.2.0**
- **MVVM Architecture**
- **Hilt for DI**
- **Room for local DB**
- **Retrofit + Moshi + OkHttp for Networking**
- **Glide for image loading**
- **Coroutines for asynchronous operations**
---

## 📦 Setup & Run

1. **Clone the Repository**

```bash
git clone https://github.com/fikriGM/githubUsers.git
cd githubUsers
```

2. **Open in Android Studio**

- Make sure you use at least Android Studio **Giraffe** or higher.
- Gradle wrapper and Hilt should already be configured.

3. **Run the App**

Use an emulator or real device with internet access. Build & run as usual.

---

## About the Developer

Developed by **Muhammad Fikri** – Android & Backend Engineer  
📧 [ciplukfikri@gmail.com](mailto:ciplukfikri@gmail.com)
