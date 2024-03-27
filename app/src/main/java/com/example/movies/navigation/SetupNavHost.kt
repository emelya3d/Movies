package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.MainViewModel
import com.example.movies.screens.DetailsScreen
import com.example.movies.screens.MainScreen
import com.example.movies.screens.SplashScreen
import com.example.movies.ui.theme.utils.Constants


sealed class Screens(val route: String) {       // может в отдельный package??
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
) { //может проще сразу просто NavHost?

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {

            MainScreen(navController , viewModel = viewModel)
        }
        composable(route = Screens.Details.route + "/{Id}") { backStackEntry ->
            DetailsScreen(navController, viewModel = viewModel,
                itemId = backStackEntry.arguments?.getString("Id") ?: "1"
            )
        }
    }
}

//3. создали sealed class Screens в новом пакете navigation
//4.  fun SetupNavHost(вместо route-> startdestination="xxx") потом добавим Screens.Splash.route
//5.  composable функции.