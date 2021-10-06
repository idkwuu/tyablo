package dev.idkwuu.tyablo.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextInput(
    @SuppressLint("ModifierParameter") modifier: Modifier? = null,
    text: String,
    onEdit: ((String) -> Unit)? = null,
    label: (@Composable () -> Unit)? = null,
    placeholder: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    isError: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    leadingIcon: (@Composable () -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current
) {
    Box {
        Box(
            (modifier ?: Modifier)
                .matchParentSize()
                .background(
                    MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    shape = MaterialTheme.shapes.medium,
                )
        )
        OutlinedTextField(
            value = text,
            onValueChange = { value -> onEdit?.let { it(value) } },
            modifier = modifier ?: Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            isError = isError,
            maxLines = maxLines,
            leadingIcon = leadingIcon,
            placeholder = placeholder,
            label = label,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            textStyle = textStyle,
        )
    }
}