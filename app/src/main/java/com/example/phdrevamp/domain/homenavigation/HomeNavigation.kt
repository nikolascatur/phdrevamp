package com.example.phdrevamp.domain.homenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.phdrevamp.R
import com.example.phdrevamp.domain.homenavigation.component.PhdBottomNavigation
import com.example.phdrevamp.presentation.navgraph.Route
import com.example.phdrevamp.ui.theme.Black400
import com.example.phdrevamp.ui.theme.Black50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNavigation() {
    val homeNavigation = remember {
        listOf(
            R.drawable.ic_home,
            R.drawable.ic_menu,
            R.drawable.ic_notif,
            R.drawable.ic_profile
        )
    }
    val navController = rememberNavController()
    val backState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = when (backState?.destination?.route) {
        Route.OnboardingScreen.route -> 0
        Route.MenuScreen.route -> 1
        Route.NotifScreen.route -> 2
        Route.ProfileScreen.route -> 3
        else -> 0
    }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Black400),
        bottomBar = {
            PhdBottomNavigation(
                items = homeNavigation,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(navController, Route.OnboardingScreen.route)
                        1 -> navigateToTab(navController, Route.MenuScreen.route)
                        2 -> navigateToTab(navController, Route.NotifScreen.route)
                        3 -> navigateToTab(navController, Route.ProfileScreen.route)
                    }
                }
            )
        }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.OnboardingScreen.route,
            modifier = Modifier.fillMaxSize().background(Black50).padding(bottomPadding)
        ) {
            composable(Route.OnboardingScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "ON Boarding Screen",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            composable(Route.MenuScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Menu Screen", style = MaterialTheme.typography.headlineLarge)
                }

            }
            composable(Route.NotifScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Notification Screen",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }

            }
            composable(Route.ProfileScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Profile Screen", style = MaterialTheme.typography.headlineLarge)
                }
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let {
            popUpTo(it) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}