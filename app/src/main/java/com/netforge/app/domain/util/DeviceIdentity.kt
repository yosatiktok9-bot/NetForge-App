package com.netforge.app.domain.util

import android.os.Build
import java.security.MessageDigest

object DeviceIdentity {
    fun getDeviceId(): String {
        val deviceInfo = "${Build.DEVICE}_${Build.MODEL}_${Build.ANDROID_ID}"
        return hashSHA256(deviceInfo)
    }

    fun hashSHA256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(input.toByteArray())
        return hash.joinToString("") { "%02x".format(it) }
    }
}
