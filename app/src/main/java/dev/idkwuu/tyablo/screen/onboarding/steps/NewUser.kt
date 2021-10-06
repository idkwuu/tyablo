package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.CustomTextInput
import dev.idkwuu.tyablo.components.WideButton

@Composable
fun NewUser(goNext: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = stringResource(R.string.onboarding_new_user),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextInput(
                text = name,
                onEdit = { name = it },
                placeholder = { Text(stringResource(R.string.setup_your_name)) },
                isError = name.isEmpty(),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                stringResource(R.string.onboarding_new_user_info),
                textAlign = TextAlign.Center
            )
        }
        WideButton(
            text = stringResource(R.string.next),
            onTap = { goNext("") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        WideButton(
            text = stringResource(R.string.info_privacy_policy),
            onTap = {  },
            transparentBackground = true
        )
    }
}