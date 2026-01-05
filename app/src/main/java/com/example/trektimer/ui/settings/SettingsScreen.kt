package com.example.trektimer.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
<<<<<<< HEAD
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
=======
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
>>>>>>> 91797783a6753e585a23147a820a638957a5e81e
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    isDarkMode: Boolean,
<<<<<<< HEAD
    onDarkModeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    unit: String,
    onUnitChange: (String) -> Unit,
    mapStyle: String,
    onMapStyleChange: (String) -> Unit
) {
    var showAbout by remember { mutableStateOf(false) }
    var showPrivacy by remember { mutableStateOf(false) }
    var showUnitDialog by remember { mutableStateOf(false) }
    var showMapStyleDialog by remember { mutableStateOf(false) }

=======
    onDarkModeChange: (Boolean) -> Unit
) {
>>>>>>> 91797783a6753e585a23147a820a638957a5e81e
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
<<<<<<< HEAD
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Logout",
                            tint = MaterialTheme.colorScheme.primary
=======
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
>>>>>>> 91797783a6753e585a23147a820a638957a5e81e
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            ListItem(
                headlineContent = { Text("Dark Mode") },
                trailingContent = {
<<<<<<< HEAD
                    Switch(checked = isDarkMode, onCheckedChange = onDarkModeChange)
                }
            )
            ListItem(
                headlineContent = { Text("Units") },
                supportingContent = { Text(unit) },
                modifier = Modifier.clickable { showUnitDialog = true }
            )
            ListItem(
                headlineContent = { Text("Map Style") },
                supportingContent = { Text(mapStyle) },
                modifier = Modifier.clickable { showMapStyleDialog = true }
            )
            ListItem(
                headlineContent = { Text("About TrekTimer") },
                supportingContent = {
                    if (showAbout) {
                        Text("TrekTimer is your ultimate companion for tracking and managing your treks. Whether you're a casual hiker or a seasoned mountaineer, TrekTimer helps you record your journeys, monitor your progress, and relive your adventures.")
                    }
                },
                modifier = Modifier.clickable { showAbout = !showAbout }
=======
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = onDarkModeChange
                    )
                }
            )
            ListItem(
                headlineContent = { Text("About TrekTimer") },
                modifier = Modifier.clickable { /* TODO */ }
>>>>>>> 91797783a6753e585a23147a820a638957a5e81e
            )
            ListItem(
                headlineContent = { Text("Version") },
                supportingContent = { Text("1.0.0") } // Replace with your app's version
            )
            ListItem(
                headlineContent = { Text("Privacy and Security") },
<<<<<<< HEAD
                supportingContent = {
                    if (showPrivacy) {
                        Text("Your privacy is important to us. We are committed to protecting your personal information and being transparent about how we handle it. We do not sell your data, and we use it only to improve your TrekTimer experience.")
                    }
                },
                modifier = Modifier.clickable { showPrivacy = !showPrivacy }
            )
        }
    }

    if (showUnitDialog) {
        UnitSelectionDialog(
            currentUnit = unit,
            onUnitSelected = { onUnitChange(it) },
            onDismiss = { showUnitDialog = false }
        )
    }

    if (showMapStyleDialog) {
        MapStyleSelectionDialog(
            currentMapStyle = mapStyle,
            onMapStyleSelected = { onMapStyleChange(it) },
            onDismiss = { showMapStyleDialog = false }
        )
    }
}

@Composable
private fun UnitSelectionDialog(
    currentUnit: String,
    onUnitSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val units = listOf("Metric (km)", "Imperial (miles)")
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Units") },
        text = {
            Column {
                units.forEach { unit ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(selected = (unit == currentUnit), onClick = { onUnitSelected(unit) }),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (unit == currentUnit),
                            onClick = { onUnitSelected(unit) }
                        )
                        Text(text = unit, modifier = Modifier.padding(start = 16.dp))
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("OK") } }
    )
}

@Composable
private fun MapStyleSelectionDialog(
    currentMapStyle: String,
    onMapStyleSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val mapStyles = listOf("Streets", "Satellite", "Outdoors")
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Map Style") },
        text = {
            Column {
                mapStyles.forEach { style ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(selected = (style == currentMapStyle), onClick = { onMapStyleSelected(style) }),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (style == currentMapStyle),
                            onClick = { onMapStyleSelected(style) }
                        )
                        Text(text = style, modifier = Modifier.padding(start = 16.dp))
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("OK") } }
    )
=======
                modifier = Modifier.clickable { /* TODO */ }
            )
        }
    }
>>>>>>> 91797783a6753e585a23147a820a638957a5e81e
}