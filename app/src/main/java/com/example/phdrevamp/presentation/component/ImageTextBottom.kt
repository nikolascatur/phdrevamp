package com.example.phdrevamp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@Composable
fun ImageTextBottom(
    @DrawableRes image: Int,
    text: String
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = image),
            contentDescription = null
        )
        Text(text = text, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun previewImageTextBottom() {
    PhdrevampTheme {
        ImageTextBottom(text = "Pizza", image = R.drawable.img_pizza)
    }
}