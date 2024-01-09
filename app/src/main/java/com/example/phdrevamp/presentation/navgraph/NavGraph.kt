package com.example.phdrevamp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.phdrevamp.domain.homenavigation.HomeNavigation
import com.example.phdrevamp.presentation.login.LoginScreen
import com.example.phdrevamp.presentation.login.LoginViewModel
import com.example.phdrevamp.presentation.register.RegisterScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.LoginScreen.route
        ) {
            composable(route = Route.LoginScreen.route) {
                val viewModel: LoginViewModel = hiltViewModel()
                val state = viewModel.state.value
                LoginScreen(
                    event = viewModel::onEvent,
                    state = state,
                    actionForgotPassword = { },
                    actionRegister = {
                        navController.navigate(route = Route.RegisterScreen.route)
                    },
                    clickLoginGoogle = {}
                )
            }
            composable(route = Route.RegisterScreen.route) {
                RegisterScreen(navController = navController)
            }
        }
        navigation(
            route = Route.HomeNavigation.route,
            startDestination = Route.OnboardingScreen.route
        ) {
            composable(route = Route.OnboardingScreen.route) {
                HomeNavigation()
            }
        }
    }
}