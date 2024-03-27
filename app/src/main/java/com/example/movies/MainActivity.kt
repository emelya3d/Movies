package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.movies.navigation.SetupNavHost
import com.example.movies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                SetupNavHost(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            // пример всплывающего сообщения
           // val toast = Toast.makeText(applicationContext, "Loading.....", Toast.LENGTH_SHORT).show()
        }
    }
}


//1. Почистили и добавили val navController = rememberNavController()
//   Вызываем SetupNavHost(navController=navController) может проще сразу NavHost()????
// 7.добавили @AndroidEntryPoint  -hilt