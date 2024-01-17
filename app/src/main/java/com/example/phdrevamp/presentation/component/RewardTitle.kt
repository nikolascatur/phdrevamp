package com.example.phdrevamp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.Dimens.ICON_BOTTOM_NAV
import com.example.phdrevamp.ui.theme.Black400
import com.example.phdrevamp.ui.theme.PHDRed500
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@Composable
fun RewardTitle(modifier: Modifier = Modifier,rewardValue: String) {

    Row(modifier = modifier) {
        Icon(
            modifier = Modifier.size(ICON_BOTTOM_NAV),
            painter = painterResource(id = R.drawable.ic_pizza),
            contentDescription = null,
            tint = PHDRed500
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier) {
            Text(
                text = "Your Reward",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = PHDRed500
            )
            Text(
                text = "$rewardValue Slice",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 8.sp),
                color = Black400
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun previewRewardTitle() {
    PhdrevampTheme() {
        RewardTitle(rewardValue = 80.toString())
    }
}