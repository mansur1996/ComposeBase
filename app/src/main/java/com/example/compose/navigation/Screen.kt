package com.example.compose.navigation

const val ARGUMENT_KEY_ID = "id"
const val ARGUMENT_KEY_NAME = "name"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")

    //passing required argument
    object Detail : Screen(route = "detail_screen/{$ARGUMENT_KEY_ID}") {
        fun passId(id: Int): String {
//            return "detail_screen/$id"
            return this.route.replace(oldValue = "{$ARGUMENT_KEY_ID}", newValue = id.toString())
        }
    }

    //passing required arguments
    object Settings : Screen(route = "settings_screen/{$ARGUMENT_KEY_ID}/{$ARGUMENT_KEY_NAME}") {
        fun passIdAndName(id: Int, name: String): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_KEY_ID}/{$ARGUMENT_KEY_NAME}", newValue = "$id/$name"
            )
        }
    }

    //passing optional argument
    object Optional : Screen(route = "optional_screen?id={$ARGUMENT_KEY_ID}") {
        fun passId(
            id: Int = 0
        ): String {
            return "optional_screen?id=$id"
        }
    }

    //passing optional arguments
    object Optional2 : Screen(route = "optional_screen?id={id}&name={name}") {
        fun passIdAndName(
            id: Int = 0,
            name: String = "Mirzayev"
        ): String {
            return "optional_screen?id=$id&name=$name"
        }
    }
}
