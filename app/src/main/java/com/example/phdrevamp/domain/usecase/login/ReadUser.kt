package com.example.phdrevamp.domain.usecase.login

import com.example.phdrevamp.domain.manager.LocalPhdManager
import com.example.phdrevamp.domain.model.User
import kotlinx.coroutines.flow.Flow

class ReadUser(private val localPhdManager: LocalPhdManager) {

    operator fun invoke(): Flow<User> = localPhdManager.readUser()
}