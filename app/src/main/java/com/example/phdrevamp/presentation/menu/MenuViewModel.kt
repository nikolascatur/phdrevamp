package com.example.phdrevamp.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phdrevamp.R
import com.example.phdrevamp.domain.model.Menu
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(MenuState())
    val state: StateFlow<MenuState> = _state.asStateFlow()

    fun selectedCategory(index: Int) {
        _state.update {
            it.copy(selectedMenuCategory = index)
        }
    }

    fun onEvent(event: EventMenu) {
        when (event) {
            is EventMenu.SelectCategory -> {
                selectedCategory(event.state.selectedMenuCategory)
            }
        }
    }

    fun callMenu() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    mapMenu = mapOf(
                        0 to listOf<Menu>(
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ),
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Burger",
                                "Double crust",
                                80000
                            ),
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Meat Lovers",
                                "Double crust",
                                80000
                            ),
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Super Supreme",
                                "Double crust",
                                80000
                            ),
                        ),
                        1 to listOf<Menu>(
                            Menu(
                                R.drawable.img_pasta,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            )
                        ),
                        2 to listOf<Menu>(
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            )
                        ),
                        3 to listOf<Menu>(
                            Menu(
                                R.drawable.img_drink_blue_ocean,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_drink_mix_berry,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_drink_tropical_punch,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_drink_blue_ocean,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            )
                        ),
                        4 to listOf<Menu>(
                            Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            ), Menu(
                                R.drawable.img_pizza_burger,
                                "Pizza Tuna melt",
                                "Double crust",
                                80000
                            )
                        ),
                    )
                )
            }
        }
    }
}