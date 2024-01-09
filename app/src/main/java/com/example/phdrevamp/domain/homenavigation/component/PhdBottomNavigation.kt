package com.example.phdrevamp.domain.homenavigation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.presentation.Dimens
import com.example.phdrevamp.ui.theme.Black500
import com.example.phdrevamp.ui.theme.PHDRed500

@Composable
fun PhdBottomNavigation(
    items: List<Int>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, icon ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Box(modifier = Modifier) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(
                                Dimens.ICON_BOTTOM_NAV
                            )
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = PHDRed500,
                    selectedIconColor = PHDRed500,
                    unselectedTextColor = Black500,
                    unselectedIconColor = Black500,
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }

}