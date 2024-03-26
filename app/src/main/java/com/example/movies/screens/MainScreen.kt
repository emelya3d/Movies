package com.example.movies.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.movies.MainViewModel
import com.example.movies.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value

    Surface(//color= MaterialTheme.colorScheme.error,
        modifier = Modifier
            .fillMaxSize()

    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(10.dp)
        ) {
            items(allMovies) { item ->
                MovieItem(item = item)
            }
        }

    }
}

@Composable
fun MovieItem(item: Movies) {
    Card(
        // colors = CardDefaults.cardColors(Color.Unspecified),
        elevation = cardElevation(4.dp),    //elevation =4.dp не катит
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable { }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image.medium),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "Rating :",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.rating.average.toString())
                }
                Row {
                    Text(
                        text = "Genre :",
                        fontWeight = FontWeight.Bold
                    )
                    item.genres.take(2).forEach{ Text(text = "$it")} // берем 2 иначе жанры полезут на другую строку
                }
                Row {
                    Text(
                        text = "Premiered :",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.premiered)
                }

            }
        }

    }

}
/*@Composable
fun MovieItem(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = item.id.toString(),
            modifier = Modifier,
            color = Color.Red
        )
        Text(text = item.name)

    }
}*/
/*@Composable
fun ElevatedCard() {

    ElevatedCard(

        Modifier
            .size(width = 280.dp, height = 200.dp,),

    ) {
        Box(Modifier.fillMaxSize()) {
            Text("Card content", Modifier.align(Alignment.Center))
        }

    }
}*/

/*

@Preview
@Composable
fun ElevatedCardSample() {
    ElevatedCard(Modifier.size(width = 480.dp, height = 200.dp)) {
        Box(Modifier.fillMaxSize()) {
            Text("Card content", Modifier.align(Alignment.Center))
        }
    }
}*/
