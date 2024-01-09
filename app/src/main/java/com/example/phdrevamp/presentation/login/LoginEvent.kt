package com.example.phdrevamp.presentation.login

sealed class LoginEvent {
    data class UpdateLogin(val loginState: LoginState) : LoginEvent()
    object LoginAction : LoginEvent()
}