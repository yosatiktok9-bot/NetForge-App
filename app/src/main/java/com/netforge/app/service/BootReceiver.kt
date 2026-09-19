package com.netforge.app.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("NetForge", "Boot completed — auto-connect check")
            // Hook: start VPN service if last session requested auto-connect
            val svc = Intent(context, NetForgeVpnService::class.java)
            context.startForegroundService(svc)
        }
    }
}
