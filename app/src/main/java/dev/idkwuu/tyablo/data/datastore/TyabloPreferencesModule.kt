package dev.idkwuu.tyablo.data.datastore

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TyabloPreferencesModule {
    @Binds
    abstract fun providesDataStore(
        tyabloPreferences: TyabloPreferencesImpl
    ): TyabloPreferences
}