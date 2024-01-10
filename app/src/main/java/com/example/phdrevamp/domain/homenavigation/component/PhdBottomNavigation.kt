package com.example.phdrevamp.domain.homenavigation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.presentation.Dimens
import com.example.phdrevamp.ui.theme.Black500
import com.example.phdrevamp.ui.theme.PHDRed200
import com.example.phdrevamp.ui.theme.PHDRed500
import com.example.phdrevamp.ui.theme.White50

@Composable
fun PhdBottomNavigation(
    items: List<Int>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 24.dp)
            .clip(CircleShape)
            .shadow(elevation = 10.dp)
            .background(Brush.verticalGradient(listOf(PHDRed200, White50, White50))),
        containerColor = Color.Transparent,
        tonalElevation = 100.dp
    ) {
        items.forEachIndexed { index, icon ->
            NavigationBarItem(
                modifier = Modifier
                    .clip(CircleShape),
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(25.dp),
                        contentAlignment = Alignment.Center
                    ) {
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
                    selectedIconColor = White50,
                    unselectedIconColor = Black500,
                    indicatorColor = PHDRed500
                )
            )
        }
    }

}