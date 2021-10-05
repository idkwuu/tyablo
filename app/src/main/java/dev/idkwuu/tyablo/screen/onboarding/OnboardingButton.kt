package dev.idkwuu.tyablo.screen.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingButton(
    text: String? = null,
    @DrawableRes icon: Int? = null,
    outlined: Boolean = false,
    onTap: () -> Unit,
) {
    Card(
        backgroundColor = if (outlined) MaterialTheme.colors.background else MaterialTheme.colors.onSurface,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth(1f),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onTap()
            }.padding(24.dp)
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "",
                    tint = if (outlined) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface,
                )
            }
            if (text != null) {
                Text(
                    text,
                    fontWeight = FontWeight.SemiBold,
                    color = if (outlined) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface,
                )
            }
        }
    }
}