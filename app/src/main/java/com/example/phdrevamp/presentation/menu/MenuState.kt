package com.example.phdrevamp.presentation.menu

import com.example.phdrevamp.domain.model.Menu

data class MenuState(
    val selectedMenuCategory: Int = 0,
    val mapMenu: Map<Int, List<Menu>> = emptyMap()

)
