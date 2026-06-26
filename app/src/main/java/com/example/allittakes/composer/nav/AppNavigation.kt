package com.example.allittakes.composer.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.allittakes.composer.ui.CounterScreen
import com.example.allittakes.composer.ui.HomeScreen
import com.example.allittakes.composer.ui.LoadUsersScreen
import com.example.allittakes.composer.ui.QueryUsersScreen
import com.example.allittakes.composer.ui.UpdateProfileScreen
import com.example.allittakes.viewmodels.CounterViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "load") {
        composable("load") {
            LoadUsersScreen(
                onFinished = {
                    navController.navigate("users") {
                        popUpTo("load") { inclusive = true }
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
                onCounter = { navController.navigate("counter") },
                onUsers = { navController.navigate("users") },
                onPosts = { navController.navigate("load") },
            )
        }

        composable("users") {
            QueryUsersScreen(

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