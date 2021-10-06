package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.CustomTextInput
import dev.idkwuu.tyablo.components.WideButton

@Composable
fun LocationPermission(goNext: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = stringResource(R.string.setup_location),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 36.dp),
                textAlign = TextAlign.Center
            )
            Icon(
                painter = painterResource(R.drawable.ic_map_pin),
                contentDescription = "",
                modifier = Modifier.padding(bottom = 36.dp).size(100.dp)
            )
        }
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = stringResource(R.string.setup_location_info),
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.setup_location_info_small_text),
                modifier = Modifier.padding(bottom = 4.dp),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
        }
        WideButton(
            text = stringResource(R.string.next),
            onTap = { goNext() },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        WideButton(
            text = stringResource(R.string.info_privacy_policy),
            onTap = {  },
            transparentBackground = true
        )
    }
}