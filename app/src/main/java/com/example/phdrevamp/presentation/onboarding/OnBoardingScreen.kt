package com.example.phdrevamp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.component.ButtonIconText
import com.example.phdrevamp.presentation.component.ImageTextBottom
import com.example.phdrevamp.presentation.component.RewardTitle
import com.example.phdrevamp.presentation.component.SearchBar
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    val scrollState = rememberPagerState(initialPage = 1) {
        bestDeals.size
    }
    val scrollVertical = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.img_pizzza_hut_logo
                ),
                contentDescription = null
            )
            Box(
                modifier = Modifier.align(Alignment.CenterVertically),
                contentAlignment = Alignment.Center
            ) {
                RewardTitle(rewardValue = "80")
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        Column(modifier = Modifier.verticalScroll(scrollVertical), content = {
            SearchBar(
                modifier = Modifier.padding(start = 13.dp, end = 13.dp),
                text = "",
                onValueChange = {}) {

            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier.padding(start = 18.dp)) {
                Text(text = "Category")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                icon.forEach {
                    ImageTextBottom(image = it.first, text = it.second)
                }
            }
            Box(modifier = Modifier.padding(start = 18.dp)) {
                Text(text = "Best Deals")
            }
            Row(
                modifier = Modifier.scrollable(
                    state = scrollState, orientation = Orientation.Horizontal
                ),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                HorizontalPager(
                    state = scrollState,
                    contentPadding = PaddingValues(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.height(260.dp)) {
                        Image(
                            painter = painterResource(id = bestDeals[it]),
                            contentDescription = null
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                menus.forEach {
                    ButtonIconText(icon = it.first, text = it.second)
                }
            }
            Spacer(modifier = Modifier.height(50.dp))

        })

    }
}

private val icon = listOf<Pair<Int, String>>(
    R.drawable.img_pizza to "Pizza",
    R.drawable.img_pasta to "Pasta",
    R.drawable.img_dissert to "Dissert",
    R.drawable.img_drinks to "Drinks",
    R.drawable.img_others to "Others"
)

private val bestDeals = listOf<Int>(
    R.drawable.img_best_deal_1,
    R.drawable.img_best_deal_1,
    R.drawable.img_best_deal_1
)

private val menus = listOf<Pair<Int, String>>(
    R.drawable.ic_dine_in to "Dine In",
    R.drawable.ic_delivery to "Delivery",
    R.drawable.ic_take_away to "Take Away",
)

@Preview(showBackground = true)
@Composable
fun previewOnBoardingScreen() {
    PhdrevampTheme {
        OnBoardingScreen()
    }
}