package dev.idkwuu.tyablo.ui.post

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Post() {
    Card(
        border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.1f)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            Modifier.padding(all = 16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth().padding(bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter("https://pbs.twimg.com/profile_images/1442143529824931840/QtrymSqA_400x400.jpg"), // Change this lmao
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(45.dp)
                        .clip(RoundedCornerShape(100.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "idkwuu",
                    style = MaterialTheme.typography.h6
                )
            }

            Text("never gonna give you up")
        }
    }
}