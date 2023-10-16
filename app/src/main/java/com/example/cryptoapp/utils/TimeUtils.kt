package com.example.cryptoapp.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.SimpleTimeZone
import java.util.TimeZone

fun convertTimestampToTime(timestamp: Int?): String {
    if (timestamp == null) return ""
    val stemp = Timestamp(timestamp.toLong() * 1000)
    val date = Date(stemp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}