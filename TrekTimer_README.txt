
TrekTimer - Mobile Application

Project Overview

TrekTimer is an outdoor activity tracking mobile application designed to help users record their runs, walks, and hikes using real-time GPS. The app allows users to track distance, speed, and routes on a live map while saving activity history for future reference. TrekTimer focuses on motivating users to stay active, explore new paths, and monitor personal fitness progress through a clean and engaging interface.

The application provides a centralized dashboard where users can start treks, view live statistics, monitor their routes, and review past activities. TrekTimer is developed using Kotlin, Jetpack Compose, MVVM architecture, Firebase Authentication, Room Database, and Android location services to deliver a smooth, accurate, and reliable tracking experience.


Key Features

Secure user authentication  
Live GPS trek tracking  
Real-time route drawing on map  
Distance and average speed calculation  
Dashboard-style home screen  
Start, pause, and stop trek controls  
Activity history storage and viewing  
Goal setting and performance tracking  
Modern and nature-inspired UI design  
Splash to dashboard navigation flow  


Technologies Used

Language: Kotlin  
User Interface: Jetpack Compose  
Architecture: MVVM  
Authentication: Firebase Authentication  
Local Storage: Room Database  
Location Services: Android GPS API  
Maps: Google Maps integration  
IDE: Android Studio  
Version Control: Git and GitHub  
Project Management: Trello  


APIs and System Services Used

Location (GPS) API – Android system service  
Used for real-time trek tracking, distance calculation, and speed monitoring.

Maps and location services  
Used to display live routes and trek paths on the map.

Firebase Authentication API  
https://firebase.google.com/docs/auth  
Used for secure login and user access control.


Application Flow

Splash Screen → Login or Register → Home Dashboard → Start Trek → Live Tracking → Trek Summary → History → Profile  


Security Implementation

Firebase Authentication is used for secure login  
Only authenticated users can access trek data  
Location access is requested only during active treks  
Sensitive credentials are not stored locally  
Local trek history is stored securely using Room Database  


Installation and Setup

Clone the project repository  
Open the project in Android Studio  
Allow Gradle to complete the build process  
Connect Firebase and enable Email and Password authentication  
Add required Maps and Location API keys  
Run the application on an emulator or physical Android device  


Agile Development

The project followed a sprint-based Agile methodology across five sprints. Development progressed from UI foundation and authentication to GPS path visualization, dashboard redesign, and finally real-world GPS integration with foreground services. This supported incremental development and continuous system improvement.


Future Enhancements

Advanced fitness analytics  
Wearable device integration  
Cloud sync and backup  
Voice-guided trekking mode  
Social challenges and leaderboards  


Useful Links

GitHub: add your GitHub link  
Trello: add your Trello link  
