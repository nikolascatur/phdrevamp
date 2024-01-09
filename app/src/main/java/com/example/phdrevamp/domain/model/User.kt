package com.example.phdrevamp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class User(
    val username: String,
    val password: String
) : Parcelable