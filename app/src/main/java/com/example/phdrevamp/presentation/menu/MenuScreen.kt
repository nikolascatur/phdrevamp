package com.example.phdrevamp.presentation.menu

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.component.ToggleImageText
import com.example.phdrevamp.presentation.component.TopBarWithReward
import com.example.phdrevamp.presentation.menu.component.MenuButton
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuScreen(
    navHostController: NavHostController,
    state: MenuState,
    event: (EventMenu) -> Unit
) {

    val scrollState = rememberPagerState(initialPage = 1) {
        deals.size
    }

    val scrollColumn = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopBarWithReward(
            navHostController = navHostController,
            title = "Muara Karang",
            composable = { padding ->
                Column(
                    modifier = Modifier
                        .padding(top = padding.calculateTopPadding())
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = 13.dp),
                        text = "Category",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Row(
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                end = 10.dp,
                                top = 5.dp
                            )
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        listOf(
                            "Pizza" to R.drawable.img_pizza,
                            "Pasta" to R.drawable.img_pasta,
                            "Dessert" to R.drawable.img_dissert,
                            "Drinks" to R.drawable.img_drinks,
                            "Others" to R.drawable.img_others
                        ).forEachIndexed { index, pair ->
                            ToggleImageText(
                                image = pair.second,
                                text = pair.first,
                                isSelected = index == state.selectedMenuCategory
                            ) {
                                event(EventMenu.SelectCategory(MenuState(selectedMenuCategory = index)))
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .scrollable(state = scrollColumn, orientation = Orientation.Vertical)
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 11.dp),
                            text = "Our Best Deals !",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        HorizontalPager(
                            state = scrollState,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(20.dp)),
                                painter = painterResource(id = deals[it]),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 11.dp),
                            text = "Pizza",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        val context = LocalContext.current

                        Log.d("okhttp","nikoo ${state.selectedMenuCategory}")
                        state.mapMenu[state.selectedMenuCategory]?.let { menus ->
                            Log.d("okhttp","nikoo menuSizee ${menus.size}")
                            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                                items(menus.size) {
                                    val menu = menus[it]
                                    MenuButton(
                                        context = context,
                                        iconMenu = menu.icon,
                                        nameMenu = menu.title,
                                        specification = menu.category,
                                        price = menu.price
                                    )
                                }
                            })
                        }
                    }
                }
            }, reward = 80
        )

    }
}

private val deals = listOf<Int>(
    R.drawable.img_best_deal_1,
    R.drawable.img_best_deal_1,
    R.drawable.img_best_deal_1
)

@Preview
@Composable
fun previewMenuScreen() {
    PhdrevampTheme {
        val context = LocalContext.current
//        MenuScreen(navHostController = NavHostController(context))
    }
}