package com.example.phdrevamp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.Dimens
import com.example.phdrevamp.ui.theme.Black400
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisLoginField(
    modifier: Modifier = Modifier,
    text: String = "",
    readOnly: Boolean,
    placeHolderText: String,
    @DrawableRes icon: Int,
    onValueChange: (String) -> Unit
) {

    Box(
        modifier = modifier
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Black400,
                    shape = MaterialTheme.shapes.large
                ),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.ICON_SIZE),
                    tint = Black400
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                textColor = Color.Black,
                cursorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorCursorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = placeHolderText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Black400
                )
            }

        )
    }

}

@Preview(showBackground = true)
@Composable
fun previewRegisLogin() {
    PhdrevampTheme {
        RegisLoginField(
            text = "nikolascatur@gmail.com",
            readOnly = true,
            placeHolderText = "Register Email",
            icon = R.drawable.ic_email_login,
            onValueChange = {

            }
        )
    }
}