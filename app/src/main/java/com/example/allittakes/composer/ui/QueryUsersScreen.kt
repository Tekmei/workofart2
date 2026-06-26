package com.example.allittakes.composer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.allittakes.data.models.local.db.UserEntity
import com.example.allittakes.viewmodels.QueryUsersViewModel

@Composable
fun QueryUsersScreen(
    viewModel: QueryUsersViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    Column {

        OutlinedTextField(

            value = state.query,

            onValueChange = viewModel::onQueryChanged,

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            placeholder = {

                Text("Search users")

            }

        )

        LazyColumn {

            items(
                state.users,
                key = { it.id }
            ) {

                UserItem(it)

            }

        }

    }

}

@Composable
fun UserItem(
    user: UserEntity
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )

    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                "${user.firstName} ${user.lastName}",
                style = MaterialTheme.typography.titleMedium
            )

            Text(user.email)

            Text(user.phone)

            Text(user.address.city)

        }

    }

}