package com.example.trektimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trektimer.ui.AppRoot
<<<<<<< HEAD
=======
import com.example.trektimer.ui.theme.TrekTimerTheme
>>>>>>> 97faeb6 (Sprint 4)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
<<<<<<< HEAD
            AppRoot()
=======
            TrekTimerTheme(
                darkTheme = false,   // or true / isSystemInDarkTheme()
                dynamicColor = false // disable wallpaper colors
            ) {
                AppRoot()
            }
>>>>>>> 97faeb6 (Sprint 4)
        }
    }
}
