package com.vandrushko.ui.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.vandrushko.ui.fragments.Configs
import kotlinx.coroutines.flow.first


object DataStoreSingleton { // TODO DataStore... key word is "data"
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Configs.LOGIN_DATA_KEY)

    suspend fun saveStringData(context: Context, key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun readStringData(context: Context, key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()

        return preferences[dataStoreKey]
    }
}