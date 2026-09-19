package com.netforge.app.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.net.VpnService
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.netforge.app.MainActivity
import com.netforge.app.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class NetForgeVpnService : VpnService() {
    private var job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)
    private val batteryOptimizer by lazy { BatteryOptimizer(this) }
    private var tunFd: Int = -1

    override fun onCreate() {
        super.onCreate()
        batteryOptimizer.acquireWakeLock()
        createNotificationChannel()
        Log.d("NetForge", "VpnService created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForegroundNotification()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        batteryOptimizer.releaseWakeLock()
        job.cancel()
        Log.d("NetForge", "VpnService destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun startForegroundNotification() {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, "netforge_tunnel")
            .setContentTitle(getString(R.string.notif_title_active))
            .setContentText("Up 0 KB/s · Down 0 KB/s")
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(1001, notification, Service.FOREGROUND_SERVICE_TYPE_SYSTEM_EXEMPTED)
        } else {
            startForeground(1001, notification)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = android.app.NotificationChannel(
                "netforge_tunnel",
                "NetForge Tunnel",
                android.app.NotificationManager.IMPORTANCE_LOW
            )
            val mgr = getSystemService(android.app.NotificationManager::class.java)
            mgr.createNotificationChannel(channel)
        }
    }
}
