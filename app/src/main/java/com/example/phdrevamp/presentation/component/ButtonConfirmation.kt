package com.example.phdrevamp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phdrevamp.ui.theme.PhdrevampTheme
import com.example.phdrevamp.ui.theme.PrimaryRed
import com.example.phdrevamp.ui.theme.White400
import com.example.phdrevamp.ui.theme.White50
import com.example.phdrevamp.ui.theme.White950

@Composable
fun ButtonConfirmation(
    modifier: Modifier = Modifier,
    text: String,
    enableButton: Boolean,
    action: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            onClick = action,
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(
                contentColor = White950,
                containerColor = PrimaryRed,
                disabledContainerColor = White400,
                disabledContentColor = White950
            ),
            enabled = enableButton
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = White50,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewButton() {
    PhdrevampTheme {
        ButtonConfirmation(text = "Login", enableButton = false) {

        }
    }
}