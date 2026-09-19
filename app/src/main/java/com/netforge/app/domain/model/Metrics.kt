package com.netforge.app.domain.model

data class Metrics(
    val bytesIn: Long = 0,
    val bytesOut: Long = 0,
    val latencyMs: Long = 0,
    val speedInBps: Long = 0,
    val speedOutBps: Long = 0,
    val sessionStartMs: Long = 0
)
