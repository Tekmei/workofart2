package com.example.allittakes.composer.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.allittakes.composer.states.LoadUsersUiState
import com.example.allittakes.viewmodels.LoadUsersViewModel


@Composable
fun LoadUsersScreen(
    onFinished: () -> Unit,
    viewModel: LoadUsersViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(state) {
        if (state is LoadUsersUiState.Success) {
            onFinished()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (val uiState = state) {

            LoadUsersUiState.Loading -> {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CircularProgressIndicator()

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text("Preparing application...")

                }

            }

            LoadUsersUiState.Success -> {
                // Navigation happens in LaunchedEffect.
            }

            is LoadUsersUiState.Error -> {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(uiState.message)

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Button(
                        onClick = {
                            viewModel.retry()
                        }
                    ) {
                        Text("Retry")
                    }

                }

            }

        }

    }

}