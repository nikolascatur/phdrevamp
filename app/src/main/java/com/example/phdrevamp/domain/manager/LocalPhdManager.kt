package com.example.phdrevamp.domain.manager

import com.example.phdrevamp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LocalPhdManager {

    suspend fun saveUser(user: User)

    fun readUser(): Flow<User>
}