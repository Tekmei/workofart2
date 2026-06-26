package com.example.allittakes.composer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToProfile: () -> Unit, onLogout: () -> Unit, onCounter:() -> Unit, onUsers:() -> Unit, onPosts:() -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Dashboard", style = MaterialTheme.typography.headlineLarge)
        Text("Welcome, Admin", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onNavigateToProfile, modifier = Modifier.fillMaxWidth()) {
            Text("Go to Update Profile")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onCounter, modifier = Modifier.fillMaxWidth()) {
            Text("Counter+")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onPosts, modifier = Modifier.fillMaxWidth()) {
            Text("Posts")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onUsers, modifier = Modifier.fillMaxWidth()) {
            Text("Users")
        }
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
            Text("Logout")
        }
    }
}