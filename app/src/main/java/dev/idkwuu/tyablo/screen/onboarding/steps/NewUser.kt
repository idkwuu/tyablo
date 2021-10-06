package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.onboarding_new_user),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )
        //Spacer(Modifier.weight(1f))
        CustomTextInput(
            text = name,
            onEdit = { name = it },
            placeholder = { Text(stringResource(R.string.setup_your_name)) },
        )
        Spacer(Modifier.weight(1f))
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