package dev.idkwuu.tyablo.state

import androidx.lifecycle.MutableLiveData
import dev.idkwuu.tyablo.enums.Theme

object ThemeState {
    val current = MutableLiveData<Theme>(Theme.SYSTEM)
    val transparentBars = MutableLiveData(false)
}