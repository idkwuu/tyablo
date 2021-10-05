package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R

@Composable
fun Verification(goNext: () -> Unit) {
    var code by remember { mutableStateOf("") }

    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.onboarding_verification),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            stringResource(R.string.onboarding_verification_desc),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            textStyle = MaterialTheme.typography.h6,
            modifier = Modifier
                .widthIn(min = 100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        FloatingActionButton(
            onClick = {  },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_right), contentDescription = "")
        }
    }
}