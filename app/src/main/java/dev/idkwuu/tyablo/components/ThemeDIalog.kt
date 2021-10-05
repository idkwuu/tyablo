package dev.idkwuu.tyablo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.enums.Theme

@Composable
fun ThemeDialog(
    onDismissRequest: () -> Unit,
    setTheme: (Theme) -> Unit,
    currentTheme: Theme
) {
    val options  = listOf<Pair<Int, Theme>>(
        Pair(R.string.theme_system, Theme.SYSTEM),
        Pair(R.string.theme_light, Theme.LIGHT),
        Pair(R.string.theme_dark, Theme.DARK)
    )
    var selectedTheme by remember { mutableStateOf(currentTheme) }

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Scrollable {
                Text(
                    text = stringResource(R.string.theme_title),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 8.dp)
                )
                options.forEach {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(it.second == selectedTheme) {
                                selectedTheme = it.second
                            }
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = it.second == selectedTheme,
                            onClick = { selectedTheme = it.second }
                        )
                        Text(
                            stringResource(it.first),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp, top = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                    ) {
                        Text(stringResource(R.string.cancel).uppercase())
                    }
                    TextButton(
                        onClick = {
                            setTheme(selectedTheme)
                            onDismissRequest()
                        }
                    ) {
                        Text(stringResource(R.string.save).uppercase())
                    }
                }
            }
        }
    }
}