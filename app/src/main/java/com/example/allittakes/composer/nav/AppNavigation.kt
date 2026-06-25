package com.example.allittakes.composer.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allittakes.composer.ui.CounterScreen
import com.example.allittakes.composer.ui.HomeScreen
import com.example.allittakes.composer.ui.LoginScreen
import com.example.allittakes.composer.ui.UpdateProfileScreen
import com.example.allittakes.viewmodels.CounterViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomeScreen(
                onNavigateToProfile = { navController.navigate("profile") },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onCounter = { navController.navigate("counter") }
            )
        }

        composable("profile") {
            UpdateProfileScreen(
                onProfileUpdated = {
                    navController.popBackStack()
                }
            )
        }

        composable("counter") {
            val counterViewModel: CounterViewModel = viewModel()
            CounterScreen(
                viewModel = counterViewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}