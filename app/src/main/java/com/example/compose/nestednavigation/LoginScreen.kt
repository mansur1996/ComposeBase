package com.example.compose.nestednavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.navigation.nav_graph.HOME_ROUTE
import com.example.compose.navigation.nav_graph.NavigationScreen

@Composable
fun LogInScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = NavigationScreen.SignUp.route)
            },
            text = "Login",
            color = Color.Magenta,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(150.dp)
                .clickable {
                    navController.navigate(HOME_ROUTE){
                        popUpTo(HOME_ROUTE)
                    }
                },
            text = "Go Back",
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ComposablePreview() {
    LogInScreen(
        navController = rememberNavController()
    )
}