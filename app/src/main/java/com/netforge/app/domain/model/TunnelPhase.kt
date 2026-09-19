package com.netforge.app.domain.model

enum class TunnelPhase {
    IDLE,
    CONNECTING,
    AUTHENTICATING,
    ESTABLISHED,
    RECONNECTING,
    DISCONNECTING,
    ERROR
}
