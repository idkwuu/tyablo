package dev.idkwuu.tyablo.ui.home.friends

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun FriendsItem(iconUrl: String) {
    Card(
        shape = CircleShape,
        modifier = Modifier.padding(horizontal = 6.dp),
        elevation = 5.dp,
        border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.1f)),
    ) {
        Image(
            painter = rememberImagePainter(iconUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
        )
    }
}