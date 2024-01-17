package com.example.phdrevamp.util.extension

import android.content.Context
import com.example.phdrevamp.R
import com.example.phdrevamp.util.Constant.CURRENCY_PATTERN
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun String?.isValidJsonArray(): Boolean {
    if (this.isNullOrEmpty())
        return false

    try {
        JSONArray(this)
    } catch (ex: JSONException) {
        return false
    } catch (ex: Exception) {
        return false
    }

    return true
}

fun String?.isValidJsonObject(): Boolean {
    if (this.isNullOrEmpty())
        return false

    try {
        JSONObject(this)
    } catch (ex: JSONException) {
        return false
    } catch (ex: Exception) {
        return false
    }

    return true
}

fun String?.isValidJson(): Boolean {
    return if (isNullOrEmpty()) false
    else (isValidJsonObject() || isValidJsonArray())
}

fun Long.addCurrency(context: Context): String {
    return context.resources.getString(
        R.string.calculator_result,
        this.toString().replace(
            Regex(CURRENCY_PATTERN),
            "$1${context.resources.getString(R.string.currency_separator)}"
        )
    )
}