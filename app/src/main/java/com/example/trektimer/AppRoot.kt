//package com.example.trektimer.ui
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeOut
//import androidx.compose.runtime.*
//import androidx.compose.ui.platform.LocalContext
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.trektimer.data.local.User
//import com.example.trektimer.location.LocationTracker
//import com.example.trektimer.ui.auth.AuthScreen
//import com.example.trektimer.ui.auth.AuthViewModel
//import com.example.trektimer.ui.home.HomeScreen
//import com.example.trektimer.ui.splash.SplashScreen
//
//import com.google.firebase.auth.FirebaseAuth
//import kotlinx.coroutines.delay
//
//@Composable
//fun AppRoot() {
//    val context = LocalContext.current
//
//    val authViewModel: AuthViewModel = viewModel()
//    val tracker = remember { LocationTracker(context) }
//
//    val auth = FirebaseAuth.getInstance()
//    var loggedInUser by remember { mutableStateOf<User?>(null) }
//    var showSplash by remember { mutableStateOf(true) }
//    var showTracking by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        delay(300)
//        showSplash = false
//
//        val firebaseUser = auth.currentUser
//        if (firebaseUser != null) {
//            val localUser = authViewModel.getLocalUser(firebaseUser.uid)
//            loggedInUser = localUser
//        }
//    }
//
//    AnimatedVisibility(
//        visible = showSplash,
//        exit = fadeOut()
//    ) {
//        SplashScreen()
//    }
//
//    if (!showSplash) {
//
//        if (loggedInUser == null) {
//            AuthScreen(onAuthSuccess = { loggedInUser = it })
//            return
//        }
//
//        // Logged in → route control
//        if (showTracking) {
//            TrackingScreen(
//                viewModel = trekViewModel,
//                tracker = tracker,
//                onExit = { showTracking = false }
//            )
//        } else {
//            HomeScreen(
//                user = loggedInUser!!,
//                onLogout = {
//                    authViewModel.logout()
//                    loggedInUser = null
//                },
//                onStartTracking = { showTracking = true }
//            )
//        }
//    }
//}






package com.example.trektimer.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trektimer.data.local.User
import com.example.trektimer.ui.auth.AuthScreen
import com.example.trektimer.ui.auth.AuthViewModel
import com.example.trektimer.ui.home.HomeScreen
import com.example.trektimer.ui.splash.SplashScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun AppRoot() {
    val context = LocalContext.current

    val authViewModel: AuthViewModel = viewModel()
    val auth = FirebaseAuth.getInstance()

    var loggedInUser by remember { mutableStateOf<User?>(null) }
    var showSplash by remember { mutableStateOf(true) }

    // Splash + Auto Login
    LaunchedEffect(Unit) {
        delay(300)
        showSplash = false

        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            loggedInUser = authViewModel.getLocalUser(firebaseUser.uid)
        }
    }

    // Splash Screen
    AnimatedVisibility(visible = showSplash, exit = fadeOut()) {
        SplashScreen()
    }

    // Main Content
    if (!showSplash) {

        // Not logged in → show login/registration
        if (loggedInUser == null) {
            AuthScreen(onAuthSuccess = { loggedInUser = it })
            return
        }

        // Logged in → show HomeScreen only
        HomeScreen(
            user = loggedInUser!!,
            onLogout = {
                authViewModel.logout()
                loggedInUser = null
            },
            onStartTracking = {
                // Tracking removed → do nothing
            }
        )
    }
}
