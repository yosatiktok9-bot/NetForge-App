package com.netforge.app.service

import android.content.Context
import android.os.PowerManager
import android.util.Log

class BatteryOptimizer(private val context: Context) {
    private var wakeLock: PowerManager.WakeLock? = null

    fun acquireWakeLock() {
        if (wakeLock?.isHeld == true) return
        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "NetForge::TunnelWakeLock").apply {
            setReferenceCounted(false)
            acquire(10 * 60 * 1000L)
        }
        Log.d("NetForge", "WakeLock acquired")
    }

    fun releaseWakeLock() {
        wakeLock?.let {
            if (it.isHeld) it.release()
        }
        wakeLock = null
        Log.d("NetForge", "WakeLock released")
    }
}
