package com.example.compose.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = BottomBarScreen.Profile.route
        ) {
            ProfileScreen()
        }
        composable(
            route = BottomBarScreen.Settings.route
        ) {
            SettingsScreen()
        }
    }
}