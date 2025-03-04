package com.uniqueidentifier

import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.BaseActivityEventListener
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableNativeMap
import com.google.android.gms.ads.identifier.AdvertisingIdClient

class UniqueIdentifierModule(private val reactContext: ReactApplicationContext) : NativeModuleSpec(reactContext) {
    private val requestCode = 1
    private var promise: Promise? = null

    init {
        reactContext.addActivityEventListener(object : BaseActivityEventListener() {
            override fun onActivityResult(activity: Activity?, code: Int, resultCode: Int, data: Intent?) {
                if (code == requestCode && resultCode == Activity.RESULT_OK) {
                    val accountName = data?.getStringExtra(AccountManager.KEY_ACCOUNT_NAME)

                    promise?.resolve(accountName)
                } else {
                    promise?.reject("ERROR", "RESULT_CANCELED")
                }
            }
        })
    }

    override fun getName() = NAME

    override
    fun getAdvertisingInfo(promise: Promise): Unit {
        val ret = WritableNativeMap()

        try {
            val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.reactContext)

            ret.putString("id", adInfo?.id)
        } catch (e: Exception) {
            promise.reject("Error getting aaid.", e)
        }
        promise.resolve(ret)
    }

    override
    fun requiresMainQueueSetup(): Boolean {
        return false
    }

    override
    fun getIcloudRecord(promise: Promise) {
        promise?.reject("ERROR", "Not implemented")
    }

    override
    fun getAndroidAccountName(message: String, promise: Promise) {
        this.promise = promise

        val activity = reactApplicationContext.currentActivity
        val intent = AccountManager.newChooseAccountIntent(
            null,
            null,
            null,
            message,
            null,
            null,
            null
        )

        activity?.startActivityForResult(intent, requestCode)
    }

    companion object {
        const val NAME = "UniqueIdentifier"
    }
}
