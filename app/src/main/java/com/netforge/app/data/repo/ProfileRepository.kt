package com.netforge.app.data.repo

import com.netforge.app.data.db.NetForgeDatabase
import com.netforge.app.data.db.ProfileEntity
import com.netforge.app.domain.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfileRepository(database: NetForgeDatabase) {
    private val dao = database.profileDao()

    fun getAllProfiles(): Flow<List<Profile>> =
        dao.getAllFlow().map { list -> list.map { it.toProfile() } }

    suspend fun getProfile(id: String): Profile? =
        dao.getById(id)?.toProfile()

    suspend fun insertProfile(profile: Profile) {
        dao.insert(profile.toEntity())
    }

    suspend fun updateProfile(profile: Profile) {
        dao.update(profile.toEntity())
    }

    suspend fun deleteProfile(id: String) {
        dao.getById(id)?.let { dao.delete(it) }
    }

    private fun Profile.toEntity(): ProfileEntity = ProfileEntity(
        id = id, name = name, host = host, port = port, mode = mode,
        payloadMode = payloadMode, payloadData = payloadData, nodeId = nodeId,
        mtu = mtu, dnsPrimary = dnsPrimary, dnsSecondary = dnsSecondary, auth = auth,
        expiry = expiry, expiryRule = expiryRule, limitData = limitData, limitTime = limitTime,
        limitRule = limitRule, bindingRule = bindingRule, lockInfo = lockInfo,
        bannerInfo = bannerInfo, advancedInfo = advancedInfo, createdAt = createdAt, updatedAt = updatedAt
    )
}
