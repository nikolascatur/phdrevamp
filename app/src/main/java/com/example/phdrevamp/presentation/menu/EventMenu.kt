package com.example.phdrevamp.presentation.menu

sealed class EventMenu {
    data class SelectCategory(val state: MenuState): EventMenu()
}
