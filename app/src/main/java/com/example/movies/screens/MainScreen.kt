package com.example.movies.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.movies.MainViewModel
import com.example.movies.data.models.Movies
import com.example.movies.navigation.Screens

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
                MovieItem(item = item, navController)
            }
        }

    }
}

@Composable
fun MovieItem(item: Movies, navController: NavController) {
    Card(
        // colors = CardDefaults.cardColors(Color.Unspecified),
        elevation = cardElevation(4.dp),    //elevation =4.dp не катит
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Details.route + "/${item.id}")

            }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
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
                        fontWeight = FontWeight.Bold,
                    )
                    item.genres.take(2)
                        //.forEach { Text(text = it) } // берем 2 иначе жанры полезут на другую строку
                        .map {
                            Text(text = it)
                        }          // можно через .map

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
