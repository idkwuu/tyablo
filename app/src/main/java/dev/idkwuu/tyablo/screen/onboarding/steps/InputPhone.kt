package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

@Composable
fun InputPhone(goNext: () -> Unit) {
    var phone by remember { mutableStateOf("") }
    val context = LocalContext.current
    val phoneNumberUtil = PhoneNumberUtil.createInstance(context)

    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.onboarding_input_phone),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            textStyle = MaterialTheme.typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = try {
                phoneNumberUtil.isPossibleNumber(phoneNumberUtil.parse(phone, "US"))
                false
            } catch (e: Exception) {
                true
            }
        )
        FloatingActionButton(
            onClick = goNext,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_right), contentDescription = "")
        }
    }
}