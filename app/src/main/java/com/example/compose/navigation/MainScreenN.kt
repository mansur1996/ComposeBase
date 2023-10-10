package com.example.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.navigation.nav_graph.SetUpNavGraph

@Composable
fun MainScreenN(){
    val navHostController = rememberNavController()
    SetUpNavGraph(navHostController = navHostController)
}
