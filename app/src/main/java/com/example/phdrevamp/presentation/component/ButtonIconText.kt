package com.example.phdrevamp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.phdrevamp.ui.theme.PHDRed400
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@Composable
fun ButtonIconText(@DrawableRes icon: Int, text: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                modifier = Modifier,
                contentDescription = null,
                tint = PHDRed400
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = text, style = MaterialTheme.typography.bodyLarge)

        }
    }
}

@Preview(showBackground = false)
@Composable
fun previewButtonIconText() {
    PhdrevampTheme {
        ButtonIconText(text = "Dine In", icon = R.drawable.ic_dine_in)
    }
}