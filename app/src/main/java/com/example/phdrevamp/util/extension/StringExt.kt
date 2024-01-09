package com.example.phdrevamp.util.extension

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