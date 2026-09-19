package com.netforge.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class NetForgeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val tunnel = NotificationChannel(
                "netforge_tunnel",
                getString(R.string.notif_channel_tunnel),
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                enableVibration(false)
                enableLights(false)
                setSound(null, null)
            }
            val mgr = getSystemService(NotificationManager::class.java)
            mgr.createNotificationChannel(tunnel)
        }
    }
}
