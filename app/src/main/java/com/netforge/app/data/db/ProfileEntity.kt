package com.netforge.app.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.netforge.app.domain.model.Profile

@Entity(tableName = "profiles")
data class ProfileEntity(
    @PrimaryKey val id: String,
    val name: String,
    val host: String,
    val port: Int,
    val mode: String,
    val payloadMode: String,
    val payloadData: String,
    val nodeId: String,
    val mtu: Int = 1500,
    val dnsPrimary: String = "1.1.1.1",
    val dnsSecondary: String = "8.8.8.8",
    val auth: String = "",
    val expiry: Long = 0L,
    val expiryRule: String = "",
    val limitData: Long = 0L,
    val limitTime: Long = 0L,
    val limitRule: String = "",
    val bindingRule: String = "",
    val lockInfo: String = "",
    val bannerInfo: String = "",
    val advancedInfo: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    fun toProfile(): Profile = Profile(
        id = id, name = name, host = host, port = port, mode = mode,
        payloadMode = payloadMode, payloadData = payloadData, nodeId = nodeId,
        mtu = mtu, dnsPrimary = dnsPrimary, dnsSecondary = dnsSecondary, auth = auth,
        expiry = expiry, expiryRule = expiryRule, limitData = limitData, limitTime = limitTime,
        limitRule = limitRule, bindingRule = bindingRule, lockInfo = lockInfo,
        bannerInfo = bannerInfo, advancedInfo = advancedInfo, createdAt = createdAt, updatedAt = updatedAt
    )
}
