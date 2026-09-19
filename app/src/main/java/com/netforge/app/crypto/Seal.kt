package com.netforge.app.crypto

import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

class Seal {
    companion object {
        fun encrypt(key: ByteArray, plaintext: ByteArray, nonce: ByteArray): ByteArray {
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val keySpec = SecretKeySpec(key, 0, key.size, "AES")
            val gcmSpec = GCMParameterSpec(128, nonce)
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec)
            return cipher.doFinal(plaintext)
        }

        fun decrypt(key: ByteArray, ciphertext: ByteArray, nonce: ByteArray): ByteArray {
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val keySpec = SecretKeySpec(key, 0, key.size, "AES")
            val gcmSpec = GCMParameterSpec(128, nonce)
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec)
            return cipher.doFinal(ciphertext)
        }
    }
}
