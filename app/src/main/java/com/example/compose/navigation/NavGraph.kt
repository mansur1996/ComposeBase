package com.example.compose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navHostController)
        }
        composable(
            route = Screen.Detail.route,
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
            route = Screen.Settings.route,
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
            route = Screen.Optional.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            Log.e("TAG", "OptionalArgs: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            OptionalScreen(navController = navHostController)
        }
        composable(
            route = Screen.Optional2.route,
            arguments = listOf(
                navArgument(ARGUMENT_KEY_ID){
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_KEY_NAME) {
                    type = NavType.StringType
                }
            )
        ){
            Log.e("TAG", "Optional2Args: ${it.arguments?.getInt(ARGUMENT_KEY_ID)}")
            Log.e("TAG", "Optional2Args: ${it.arguments?.getString(ARGUMENT_KEY_NAME)}")
            OptionalScreen2(navController = navHostController)
        }
    }
}