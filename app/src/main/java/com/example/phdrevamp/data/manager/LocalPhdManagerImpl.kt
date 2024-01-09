package com.example.phdrevamp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.phdrevamp.domain.manager.LocalPhdManager
import com.example.phdrevamp.domain.model.User
import com.example.phdrevamp.util.Constant.SAVED_USER
import com.example.phdrevamp.util.extension.generateStringToObject
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalPhdManagerImpl(
    private val context: Context,
    private val gson: Gson
) : LocalPhdManager {
    override suspend fun saveUser(user: User) {
        val userString = gson.toJson(user)
        context.dataStore.edit {
            it[PreferenceKey.USER_SAVED] = userString
        }
    }

    override fun readUser(): Flow<User> =
        context.dataStore.data.map {
            it[PreferenceKey.USER_SAVED].generateStringToObject<User>() ?: User("", "")
        }
}

private val readOnlyProperty = preferencesDataStore(SAVED_USER)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferenceKey {
    val USER_SAVED = stringPreferencesKey(SAVED_USER)
}