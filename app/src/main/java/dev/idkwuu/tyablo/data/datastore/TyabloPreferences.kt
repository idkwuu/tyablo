package dev.idkwuu.tyablo.data.datastore

import dev.idkwuu.tyablo.enums.Theme
import kotlinx.coroutines.flow.Flow

interface TyabloPreferences {
    val themeMode: Flow<Theme>
    suspend fun setThemeMode(mode: Theme)
}