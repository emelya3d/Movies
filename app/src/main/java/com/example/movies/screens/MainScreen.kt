package com.example.movies.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {

    ElevatedCard()
}

@Composable
fun ElevatedCard() {

    ElevatedCard(

        Modifier.size(
            width = 280.dp,
            height = 200.dp,


        )

    ) {
        Box(Modifier.fillMaxSize()) {
            Text("Card content", Modifier.align(Alignment.Center))
        }

    }
}


@Preview
@Composable
fun ElevatedCardSample() {
    ElevatedCard(Modifier.size(width = 480.dp, height = 200.dp)) {
        Box(Modifier.fillMaxSize()) {
            Text("Card content", Modifier.align(Alignment.Center))
        }
    }
}