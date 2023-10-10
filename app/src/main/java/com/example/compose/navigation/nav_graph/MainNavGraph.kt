package com.example.compose.navigation.nav_graph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.compose.navigation.DetailScreen
import com.example.compose.navigation.HomeScreen
import com.example.compose.navigation.OptionalScreen
import com.example.compose.navigation.OptionalScreen2
import com.example.compose.navigation.SettingsScreen

fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = NavigationScreen.Home.route,
        route = HOME_ROUTE
    ){
        composable(
            route = NavigationScreen.Home.route
        ) {
            HomeScreen(navController = navHostController)
        }
        composable(
            route = NavigationScreen.Detail.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            Log.e("TAG", "DetailArgs: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            DetailScreen(navController = navHostController)
        }
        composable(
            route = NavigationScreen.Settings.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID) {
                    type = NavType.IntType
                },
                navArgument(ARGUMENT_KEY_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.e("TAG", "SettingArgs: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            Log.e("TAG", "SettingArgs: ${it.arguments?.getString(ARGUMENT_KEY_NAME)}")
            SettingsScreen(navController = navHostController)
        }
        composable(
            route = NavigationScreen.Optional.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            Log.e("TAG", "OptionalArgs: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            OptionalScreen(navController = navHostController)
        }
        composable(
            route = NavigationScreen.Optional2.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_KEY_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.e("TAG", "Optional2Args: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            Log.e("TAG", "Optional2Args: ${it.arguments?.getString(ARGUMENT_KEY_NAME)}")
            OptionalScreen2(navController = navHostController)
        }
    }
}