package com.example.compose.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose.nestednavigation.LogInScreen
import com.example.compose.nestednavigation.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = NavigationScreen.LogIn.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(
            route = NavigationScreen.LogIn.route
        ) {
            LogInScreen(navController = navHostController)
        }
        composable(
            route = NavigationScreen.SignUp.route
        ) {
            SignUpScreen(navController = navHostController)
        }
    }
}