package com.example.phdrevamp.domain.usecase.login

import com.example.phdrevamp.domain.manager.LocalPhdManager
import com.example.phdrevamp.domain.model.User

class SaveLoginUser(private val localPhdManager: LocalPhdManager) {

    suspend operator fun invoke(user: User) {
        localPhdManager.saveUser(user)
    }
}