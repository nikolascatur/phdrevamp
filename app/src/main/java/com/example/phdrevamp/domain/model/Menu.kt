package com.example.phdrevamp.domain.model

import androidx.annotation.DrawableRes

data class Menu(
    @DrawableRes val icon: Int,
    val title: String,
    val category: String,
    val price: Long
)
