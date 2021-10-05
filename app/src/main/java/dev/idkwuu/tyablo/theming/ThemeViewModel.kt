package dev.idkwuu.tyablo.theming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.idkwuu.tyablo.data.datastore.TyabloPreferences
import dev.idkwuu.tyablo.enums.Theme
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    val tyabloPreferences: TyabloPreferences
): ViewModel() {
    val isDarkModeActive = MutableLiveData<Boolean>()
    fun setIsDarkModeActive(isActive: Boolean) {
        isDarkModeActive.value = isActive
    }

    val themeMode = tyabloPreferences.themeMode.asLiveData()
    fun setThemeMode(mode: Theme) {
        viewModelScope.launch {
            tyabloPreferences.setThemeMode(mode)
        }
    }
}