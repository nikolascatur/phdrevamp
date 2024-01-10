package com.example.phdrevamp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.phdrevamp.presentation.navgraph.NavGraph
import com.example.phdrevamp.ui.theme.PhdrevampTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhdrevampTheme(dynamicColor = false) {
                val systemUiEffect = rememberSystemUiController()
                SideEffect {
                    systemUiEffect.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = true
                    )
                }
                val mainViewModel: MainViewModel = hiltViewModel()
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = mainViewModel.startDestination.value)
                }
            }
        }
    }
}
