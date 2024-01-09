package com.example.phdrevamp.di

import android.app.Application
import com.example.phdrevamp.data.manager.LocalPhdManagerImpl
import com.example.phdrevamp.domain.manager.LocalPhdManager
import com.example.phdrevamp.domain.usecase.login.ReadUser
import com.example.phdrevamp.domain.usecase.login.SaveLoginUser
import com.example.phdrevamp.domain.usecase.login.UserUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGson(): Gson = Gson()

    @Provides
    @Singleton
    fun providesLocalData(application: Application, gson: Gson): LocalPhdManager =
        LocalPhdManagerImpl(application, gson)

    @Provides
    @Singleton
    fun providesUserLocalManager(localPhdManager: LocalPhdManager): UserUseCase = UserUseCase(
        ReadUser(localPhdManager),
        SaveLoginUser(localPhdManager)
    )
}