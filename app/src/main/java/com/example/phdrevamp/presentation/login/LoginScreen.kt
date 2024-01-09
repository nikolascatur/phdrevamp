package com.example.phdrevamp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.phdrevamp.R
import com.example.phdrevamp.presentation.component.ButtonConfirmation
import com.example.phdrevamp.presentation.component.RegisLoginField
import com.example.phdrevamp.presentation.component.SpannableClickableText
import com.example.phdrevamp.ui.theme.PrimaryRed

@Composable
fun LoginScreen(
    event: (LoginEvent) -> Unit,
    state: LoginState,
    actionForgotPassword: () -> Unit,
    actionRegister: () -> Unit,
    clickLoginGoogle: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.img_banner_login),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Welcome back",
            modifier = Modifier,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "A slice, anytime anywhere",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(50.dp))
        RegisLoginField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            text = state.email,
            readOnly = false,
            placeHolderText = "Registered Email",
            icon = R.drawable.ic_email_login,
            onValueChange = {
                event(LoginEvent.UpdateLogin(state.copy(email = it)))
            }
        )
        Spacer(modifier = Modifier.height(26.dp))
        RegisLoginField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            text = state.password,
            readOnly = false,
            placeHolderText = "Password to sign in your account",
            icon = R.drawable.ic_password_login,
            onValueChange = {
                event(LoginEvent.UpdateLogin(state.copy(password = it)))
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, top = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                modifier = Modifier.clickable(onClick = actionForgotPassword),
                color = PrimaryRed,
                text = "Forgot Password",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        ButtonConfirmation(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = "Login",
            enableButton = state.isValid,
            action = {event(LoginEvent.LoginAction)}
        )

        Spacer(modifier = Modifier.height(10.dp))
        val tagRegister = "tag_register"
        SpannableClickableText(
            tagRegister,
            "Register Now",
            "Don\'t have an account yet?",
            actionRegister
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier.clickable(onClick = clickLoginGoogle),
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = null
        )
    }

}

//@Preview(showBackground = true)
//@Composable
//fun previewLogin() {
//    PhdrevampTheme {
//        LoginScreen(
//            actionForgotPassword = { /*TODO*/ },
//            actionLogin = { /*TODO*/ },
//            actionRegister = {},
//            clickLoginGoogle = {})
//    }
//}