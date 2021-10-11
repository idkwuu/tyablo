package dev.idkwuu.tyablo.ui.home.friends

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FriendsRow(
    scrollState: ScrollState
) {
    Row(
        Modifier
            .horizontalScroll(scrollState)
            .padding(vertical = 8.dp),
    ) {
        Spacer(Modifier.width(16.dp))
        FriendsItem("https://docs.idkwuu.dev/ratioidk.png")
        FriendsItem("https://docs.idkwuu.dev/ratiodeclined.png")
        FriendsItem("https://docs.idkwuu.dev/ratioaccepted.png")
        FriendsItem("https://docs.idkwuu.dev/ratioidk.png")
        FriendsItem("https://docs.idkwuu.dev/ratiodeclined.png")
        FriendsItem("https://docs.idkwuu.dev/ratioaccepted.png")
        FriendsItem("https://docs.idkwuu.dev/ratioidk.png")
        FriendsItem("https://docs.idkwuu.dev/ratiodeclined.png")
        FriendsItem("https://docs.idkwuu.dev/ratioaccepted.png")
        FriendsItem("https://docs.idkwuu.dev/ratioidk.png")
        FriendsItem("https://docs.idkwuu.dev/ratiodeclined.png")
        FriendsItem("https://docs.idkwuu.dev/ratioaccepted.png")
        Spacer(Modifier.width(16.dp))
    }
}