package com.example.phdrevamp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithReward(
    navHostController: NavHostController,
    title: String,
    composable: @Composable (PaddingValues) -> Unit,
    reward: Long
) {

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    RewardTitle(modifier = Modifier.padding(end = 25.dp),rewardValue = reward.toString())
                }
            },
            navigationIcon = {
                IconButton(onClick = { navHostController.navigateUp() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            })
    }, content = composable)
}

@Preview
@Composable
fun previewTopBarWithReward() {
    PhdrevampTheme {
        val context = LocalContext.current
        TopBarWithReward(
            navHostController = NavHostController(context),
            title = "back",
            composable = {},
            reward = 80
        )

    }
}