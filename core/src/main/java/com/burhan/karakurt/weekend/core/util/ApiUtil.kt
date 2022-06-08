package com.burhan.karakurt.weekend.core.util

import okhttp3.internal.and
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object ApiUtil {

    const val PUBLIC_API_KEY = "c717856b55cf4b56bdded0f4017a23fd"
    const val PRIVATE_API_KEY = "e17bb8389bf09360b7fca93842fbc924e2c3b0a6"
    const val TIME_STAMP = "4321456"

    fun getMd5Key(): String? {
        var hash: String? = null
        val input: String = TIME_STAMP + PRIVATE_API_KEY + PUBLIC_API_KEY
        try {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            val md5Bytes: ByteArray = md.digest(input.toByteArray())
            val md5 = StringBuilder()
            for (i in md5Bytes.indices) {
                md5.append(Integer.toHexString(md5Bytes[i] and 0xFF or 0x100).substring(1, 3))
            }
            hash = md5.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return hash
    }
}