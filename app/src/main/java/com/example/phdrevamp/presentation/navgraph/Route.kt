package com.example.phdrevamp.presentation.navgraph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val navArgument: List<NamedNavArgument> = emptyList()
) {
    object LoginScreen : Route("LoginScreen")
    object RegisterScreen : Route("RegisterScreen")

    object HomeNavigation : Route("HomeNavigation")

    object AppStartNavigation : Route("AppStartNavigation")
}