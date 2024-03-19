package com.example.movies.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies.navigation.Screens
import com.example.movies.ui.theme.MoviesTheme
import kotlinx.coroutines.delay

@Composable

fun SplashScreen(navController: NavController) {
    // Анимация
    var startAnimate by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(3000),
        label = ""
    )
    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(2000)

        navController.navigate(Screens.Main.route)

    }
    Splash(alfa = alphaAnimation.value)
}

@Composable
fun Splash(alfa: Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

        )
    {
        Icon(
            modifier = Modifier
                .size(128.dp)
                .alpha(alpha = alfa),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = Black
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PrevSplash() {
    MoviesTheme {
        Splash(1f)
    }
}