package com.example.allittakes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allittakes.composer.states.LoadUsersUiState
import com.example.allittakes.composer.states.QueryUsersUiState
import com.example.allittakes.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QueryUsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val query =
        MutableStateFlow("")

    val uiState =
        query
            .debounce(300)
            .distinctUntilChanged()
            .flatMapLatest {

                repository.searchUsers(it)

            }
            .map {

                QueryUsersUiState(

                    query = query.value,

                    users = it,

                    loading = false

                )

            }
            .stateIn(

                scope = viewModelScope,

                started = SharingStarted.WhileSubscribed(5000),

                initialValue = QueryUsersUiState()

            )

    fun onQueryChanged(
        value: String
    ) {

        query.value = value

    }

}