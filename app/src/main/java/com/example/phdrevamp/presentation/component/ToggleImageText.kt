package com.example.phdrevamp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.ui.theme.PHDRed600
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@Composable
fun ToggleImageText(
    @DrawableRes image: Int,
    text: String,
    isSelected: Boolean,
    click: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(width = 70.dp, height = 98.dp)
            .clickable {
                click()
            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                PHDRed600
            } else {
                Color.Transparent
            }
        )
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(65.dp)
                    .background(Color.Transparent)
                    .padding(top = 10.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = if (isSelected) {
                            Color.White
                        } else {
                            Color.Black
                        }
                    )
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun previewToggleImage() {
    PhdrevampTheme() {
        ToggleImageText(image = R.drawable.img_pizza, text = "Pizza", isSelected = true, {})
    }
}