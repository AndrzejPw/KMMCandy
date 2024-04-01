This is a Kotlin Multiplatform project targeting Android, iOS. It can be starting point to create a project that tries to share all business logic between Android and iOS while keeping UI native. I decided to go with native UI because Compose Multiplatform does not support navigation natively yet. 

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` contains pure composables (views) - that means the only allowed arguments for these composables are state and callbacks.
  - `androidMain` contains Android application and composables related to navigation. This module is responsible for navigation, creating viewModels and using composables from commonMain

* `/iosApp` contains iOS applications. IOS app uses the ViewModels from Shared module. 


* `/shared` is for the code that will be shared between all targets in the project. It contains ViewModels too thanks to [KMM-ViewModel library](https://github.com/rickclephas/KMM-ViewModel)
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
