package com.example.compose.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ) {
        homeNavGraph(navHostController = navHostController)
        authNavGraph(navHostController = navHostController)
    }
}