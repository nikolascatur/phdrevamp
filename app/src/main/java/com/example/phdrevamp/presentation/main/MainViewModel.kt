package com.example.phdrevamp.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phdrevamp.domain.usecase.login.UserUseCase
import com.example.phdrevamp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    init {
        userUseCase.readUser().onEach { user ->
            _startDestination.value = if (user.password.isNotEmpty() && user.username.isNotEmpty()) {
                Route.HomeNavigation.route
            } else {
                Route.AppStartNavigation.route
            }
        }.launchIn(viewModelScope)
    }
}