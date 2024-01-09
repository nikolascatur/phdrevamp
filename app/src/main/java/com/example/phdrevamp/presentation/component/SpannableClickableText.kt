package com.example.phdrevamp.presentation.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.phdrevamp.ui.theme.PrimaryRed

@Composable
fun SpannableClickableText(
    tag: String,
    clickableText: String,
    nonClickable: String,
    actionClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
//        val registerValue = "Register Now"
//        val snipped = "Don\'t have an account yet? $registerValue"
        val snipped = "$nonClickable $clickableText"
        append(snipped)
        val startIndex = snipped.indexOf(clickableText)
        val endIndex = startIndex + clickableText.length
        addStyle(
            style = SpanStyle(
                color = PrimaryRed,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ), start = startIndex, end = endIndex
        )
        addStringAnnotation(
            tag,
            clickableText,
            start = startIndex,
            end = endIndex
        )
    }
    ClickableText(text = annotatedText, onClick = {
        annotatedText.getStringAnnotations(it, it).firstOrNull()?.let {
            actionClick()
        }
    })
}