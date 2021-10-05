package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.screen.onboarding.OnboardingButton
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
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.onboarding_input_phone),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row(
            Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            TextField(
                value = intCode,
                onValueChange = { if (it.length < 5) intCode = it },
                //textStyle = MaterialTheme.typography.h6.copy(textAlign = TextAlign.End),
                modifier = Modifier.width(120.dp).padding(end = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = intCode.isEmpty(),
                singleLine = true,
                leadingIcon = { Text("+") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                placeholder = { Text("1", textAlign = TextAlign.End) },
                label = { Text("Code") }
            )
            TextField(
                value = phone,
                onValueChange = { phone = it },
                //textStyle = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = phone.length < 5,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                placeholder = { Text("1234567890") },
                label = { Text("Phone number") }
            )
        }
        FloatingActionButton(
            onClick = { if (intCode.isNotEmpty() && phone.length >= 5) goNext("+$intCode$phone") },
            backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = if (intCode.isNotEmpty() && phone.length >= 5) 1f else 0.5f),
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Icon(
                painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Next",
                tint = MaterialTheme.colors.surface
            )
        }
    }
}