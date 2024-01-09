package com.example.phdrevamp.util.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.io.StringReader

inline fun <reified T> String?.generateStringToObject(): T? {
    if (isNullOrEmpty() || isValidJson().not()) return null

    val strReader = StringReader(orEmpty())
    val reader = JsonReader(strReader).apply {
        isLenient = true
    }
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(reader, type) as T?
}