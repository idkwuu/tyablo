package dev.idkwuu.tyablo.ui.onboarding.steps.inputphone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.CustomTextInput
import dev.idkwuu.tyablo.components.WideButton
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

@Composable
fun InputPhone(goNext: (String) -> Unit) {
    var intCode by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    val context = LocalContext.current
    val phoneNumberUtil = PhoneNumberUtil.createInstance(context)

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = stringResource(R.string.onboarding_whats_phone),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
        Row(
            Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) {
            CustomTextInput(
                text = intCode,
                onEdit = { if (it.length < 5) intCode = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                placeholder = { Text("1") },
                modifier = Modifier
                    .widthIn(max = 130.dp)
                    .padding(end = 8.dp),
                leadingIcon = { Text("+") },
                maxLines = 1
            )
            CustomTextInput(
                text = phone,
                onEdit = { phone = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                placeholder = { Text("1234567890") },
                maxLines = 1
            )
        }
        WideButton(
            text = stringResource(R.string.next),
            onTap = { goNext(phone) },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        WideButton(
            text = stringResource(R.string.go_back),
            onTap = {  },
            transparentBackground = true,
        )
    }
}