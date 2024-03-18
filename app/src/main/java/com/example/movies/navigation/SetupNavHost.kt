package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.ui.theme.utils.Constants

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {

        }
        composable(route = Screens.Main.route) {

        }
        composable(route = Screens.Details.route) {

        }
    }

}
//3. создали sealed class Screens в новом пакете navigation
//4.  fun SetupNavHost
//5.  composable функции.