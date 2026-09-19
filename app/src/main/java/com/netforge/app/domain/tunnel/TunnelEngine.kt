package com.netforge.app.domain.tunnel

import com.netforge.app.domain.model.Metrics
import com.netforge.app.domain.model.Profile
import com.netforge.app.domain.model.TunnelPhase
import kotlinx.coroutines.flow.StateFlow

interface TunnelEngine {
    val phase: StateFlow<TunnelPhase>
    val metrics: StateFlow<Metrics>

    suspend fun connect(profile: Profile)
    suspend fun disconnect()
    suspend fun reconnect()
}
