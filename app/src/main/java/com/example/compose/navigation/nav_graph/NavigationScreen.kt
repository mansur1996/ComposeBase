package com.example.compose.navigation.nav_graph

const val ARGUMENT_KEY_ID = "id"
const val ARGUMENT_KEY_NAME = "name"

const val AUTHENTICATION_ROUTE = "authentication_root_route"
const val HOME_ROUTE = "main_route"
const val ROOT_ROUTE = "root_route"

sealed class NavigationScreen(val route: String) {
    object Home : NavigationScreen(route = "home_screen")

    //passing required argument
    object Detail : NavigationScreen(route = "detail_screen/{$ARGUMENT_KEY_ID}") {
        fun passId(id: Int): String {
//            return "detail_screen/$id"
            return this.route.replace(oldValue = "{$ARGUMENT_KEY_ID}", newValue = id.toString())
        }
    }

    //passing required arguments
    object Settings : NavigationScreen(route = "settings_screen/{$ARGUMENT_KEY_ID}/{$ARGUMENT_KEY_NAME}") {
        fun passIdAndName(id: Int, name: String): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_KEY_ID}/{$ARGUMENT_KEY_NAME}", newValue = "$id/$name"
            )
        }
    }

    //passing optional argument
    object Optional : NavigationScreen(route = "optional_screen?id={$ARGUMENT_KEY_ID}") {
        fun passId(
            id: Int = 0
        ): String {
            return "optional_screen?id=$id"
        }
    }

    //passing optional arguments
    object Optional2 : NavigationScreen(route = "optional_screen?id={id}&name={name}") {
        fun passIdAndName(
            id: Int = 0,
            name: String = "Mirzayev"
        ): String {
            return "optional_screen?id=$id&name=$name"
        }
    }

    object SignUp : NavigationScreen(route = "sign_up")
    object LogIn : NavigationScreen(route = "log_in")
}
