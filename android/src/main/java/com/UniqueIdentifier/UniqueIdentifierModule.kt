package com.uniqueidentifier

import android.accounts.AccountManager
import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.BaseActivityEventListener
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext

class UniqueIdentifierModule(reactContext: ReactApplicationContext) : NativeModuleSpec(reactContext) {
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

    override fun requiresMainQueueSetup(): Boolean {
        return false
    }

    override fun getIcloudRecord(promise: Promise) {
        promise.reject("ERROR", "Not implemented")
    }

    override fun getAndroidAccountName(message: String, promise: Promise) {
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
