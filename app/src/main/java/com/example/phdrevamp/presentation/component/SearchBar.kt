package com.example.phdrevamp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.ui.theme.PHDRed300
import com.example.phdrevamp.ui.theme.PhdrevampTheme
import com.example.phdrevamp.ui.theme.White300
import com.example.phdrevamp.ui.theme.White50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    Box(modifier = modifier.background(color = Color.Transparent)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = White300, shape = MaterialTheme.shapes.medium),
            value = text,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = "Mau Makan Apa Hari ini",
                    style = MaterialTheme.typography.bodyLarge.copy(color = White300)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = PHDRed300
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_pink_close),
                    contentDescription = null,
                    tint = PHDRed300,
                    modifier = Modifier.clickable {
                        onValueChange("")
                    }
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = White50,
                textColor = Color.Black,
                cursorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorCursorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() })
        )
    }
}

@Preview(showBackground = false)
@Composable
fun previewSearchBar() {
    PhdrevampTheme {
        SearchBar(text = "nasi goreng", onValueChange = {}, onSearch = {})
    }
}