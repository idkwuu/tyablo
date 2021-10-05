package dev.idkwuu.tyablo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.idkwuu.tyablo.enums.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

@Singleton
class TyabloPreferencesImpl @Inject constructor(
    @ApplicationContext appContext: Context
): TyabloPreferences {
    private val settingsDataStore = appContext.dataStore

    override suspend fun setThemeMode(mode: Theme) {
        settingsDataStore.edit {
            it[THEME] = mode.ordinal
        }
    }

    override val themeMode: Flow<Theme> = settingsDataStore.data.map {
        Theme.values()[it[THEME] ?: 0] // Theme.SYSTEM.ordinal is 0
    }

    companion object Settings {
        val THEME = intPreferencesKey("theme")
    }
}