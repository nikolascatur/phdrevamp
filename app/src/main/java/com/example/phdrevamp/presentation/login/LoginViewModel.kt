package com.example.phdrevamp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phdrevamp.domain.manager.LocalPhdManager
import com.example.phdrevamp.domain.model.User
import com.example.phdrevamp.domain.usecase.login.SaveLoginUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val user: LocalPhdManager) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.UpdateLogin -> {
                with(event.loginState) {
                    _state.value = _state.value.copy(
                        email = email,
                        password = password,
                        isValid = validationEmail(email) && validationPassword(password)
                    )
                }
            }

            is LoginEvent.LoginAction -> {
                val dataState = state.value
                viewModelScope.launch {
                    user.saveUser(User(dataState.email, dataState.password))
                }
            }
        }
    }

    private fun validationEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validationPassword(password: String): Boolean {
        return password.length >= 6
    }
}