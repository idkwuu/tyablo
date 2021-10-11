package dev.idkwuu.tyablo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.statusBarsPadding
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.ui.Map
import dev.idkwuu.tyablo.ui.home.friends.FriendsRow
import dev.idkwuu.tyablo.ui.post.Post

@Composable
fun Home() {
    val friendsRowScroll = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onSurface,
                title = { Text(stringResource(R.string.home)) },
                navigationIcon = {
                    // Profile picture
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = rememberImagePainter("https://pbs.twimg.com/profile_images/1442143529824931840/QtrymSqA_400x400.jpg"), // Change this lmao
                            contentDescription = "",
                            modifier = Modifier
                                .padding(8.dp)
                                .size(35.dp)
                                .clip(RoundedCornerShape(100.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(painterResource(R.drawable.ic_qr_code_scanner), contentDescription = "")
                    }
                    IconButton(onClick = {  }) {
                        Icon(painterResource(R.drawable.ic_plus), contentDescription = "")
                    }
                }
            )
        }
    ) {
        LazyColumn(
            contentPadding = rememberInsetsPaddingValues(
                insets = LocalWindowInsets.current.navigationBars,
                applyBottom = true,
            )
        ) {
            item {
                FriendsRow(friendsRowScroll)
            }
            item {
                Card(
                    Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(200.dp)
                ) {
                    Map()
                }
            }
            items(10) {
                Post()
            }
        }
    }
}