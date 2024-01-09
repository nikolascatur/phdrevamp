package com.example.phdrevamp.presentation.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.component.ButtonConfirmation
import com.example.phdrevamp.presentation.component.RegisLoginField
import com.example.phdrevamp.presentation.component.ScreenWithBackButton
import com.example.phdrevamp.presentation.component.SpannableClickableText
import com.example.phdrevamp.ui.theme.PhdrevampTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val selectedOption = remember { mutableStateOf("male") }
    ScreenWithBackButton(
        navHostController = navController,
        title = "Register"
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 16.dp, end = 16.dp, top = 92.dp)
        ) {
            RegisLoginField(
                readOnly = false,
                placeHolderText = "First Name",
                icon = R.drawable.ic_people,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Last Name",
                icon = R.drawable.ic_people,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Phone Number",
                icon = R.drawable.ic_phone,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Email",
                icon = R.drawable.ic_email_login,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Password",
                icon = R.drawable.ic_password_login,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Confirm password",
                icon = R.drawable.ic_password_login,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            RegisLoginField(
                readOnly = false,
                placeHolderText = "Select Your Birthday",
                icon = R.drawable.ic_birthday,
                onValueChange = {})
            Spacer(modifier = Modifier.height(26.dp))
            Text(text = "Gender", style = MaterialTheme.typography.bodyMedium)
            Row {
                listOf("Female", "Male").forEach {
                    RadioButton(
                        selected = selectedOption.value == it,
                        onClick = { selectedOption.value = it }

                    )

                    Text(text = it, modifier = Modifier.padding(top = 11.dp))
                }
            }
            Spacer(modifier = Modifier.height(26.dp))
            ButtonConfirmation(text = "Sign Up", enableButton = false) {

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                SpannableClickableText(
                    tag = "tag_login",
                    clickableText = "Login Now",
                    nonClickable = "Already Registered? "
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewLayout() {
    PhdrevampTheme {
        val context = LocalContext.current
        RegisterScreen(navController = NavHostController(context))

    }
}