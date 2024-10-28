package com.example.diancafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape // Import untuk RoundedCornerShape
import com.example.diancafe.ui.theme.DianCafeTheme

// Data class Artwork (jika belum ada)
data class Artwork(val imageResourceId: Int, val title: String, val year: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DianCafeTheme {
                DianCafeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DianCafeApp() {
    val artworks = listOf(
        Artwork(R.drawable.d1, "Unik Kopi", "2024"),
        Artwork(R.drawable.d2, "Unik Teh", "2024"),
        Artwork(R.drawable.d3, "Unik Cocktail", "2024"),
        Artwork(R.drawable.d4, "Unik Mocktail", "2024"),
        Artwork(R.drawable.d5, "Unik Appetizer", "2024"),
        Artwork(R.drawable.d7, "Main Course", "2024"),
        Artwork(R.drawable.d8, "Unik Dessert", "2024"),
        Artwork(R.drawable.d9, "Pasta Salad", "2024"),
        Artwork(R.drawable.d10, "Pasta Salad", "2024"),
        Artwork(R.drawable.d11, "Pizza", "2024"),
        Artwork(R.drawable.d12, "Ayam Keju", "2024"),
        Artwork(R.drawable.d13, "Mie Dok Dok", "2024"),
        // Add more artworks here
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("DIAN CAFE", color = Color.White)
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFFA0522D) // coklat
                )
            )
        },
        bottomBar = {
            // Footer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Copyright @DianCafe",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { innerPadding ->
        Column( // Bungkus LazyVerticalGrid dengan Column
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F0F0)) // Light gray background
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text( // Judul "Daftar Menu"
                text = "Daftar Menu",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // 2 kolom
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(artworks) { artwork ->
                    ArtworkItem(artwork)
                }
            }
        }
    }
}


@Composable
fun ArtworkItem(artwork: Artwork) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = artwork.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp)), // Melengkungkan sudut
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artwork.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Menampilkan harga
        Text(
            text = artwork.year,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}