package dev.idkwuu.tyablo.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WideButton(
    modifier: Modifier = Modifier,
    text: String,
    transparentBackground: Boolean = false,
    onTap: () -> Unit,
) {
    Card(
        backgroundColor = if (transparentBackground) Color.Transparent else MaterialTheme.colors.primary,
        elevation = 0.dp,
        modifier = modifier.fillMaxWidth(1f),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onTap()
            }.padding(16.dp)
        ) {
            Text(
                text,
                fontWeight = FontWeight.SemiBold,
                color = if (transparentBackground) MaterialTheme.colors.onSurface else Color.White,
            )
        }
    }
}