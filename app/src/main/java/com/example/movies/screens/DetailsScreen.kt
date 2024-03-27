package com.example.movies.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movies.MainViewModel
import com.example.movies.navigation.Screens

@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, itemId: String) {
    Text(text = "DetailsScreen: item id: ${itemId}")

}
