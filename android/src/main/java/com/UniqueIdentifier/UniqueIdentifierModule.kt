package com.uniqueidentifier

import android.Manifest
import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.modules.core.PermissionAwareActivity
import com.facebook.react.modules.core.PermissionListener
import com.facebook.react.bridge.WritableNativeArray
import com.facebook.react.bridge.WritableNativeMap

class UniqueIdentifierModule(reactContext: ReactApplicationContext) : NativeModuleSpec(reactContext) {
  override fun getName() = NAME

  override fun requiresMainQueueSetup(): Boolean {
    return true
  }

  override fun getIcloudRecord(promise: Promise) {
    promise.resolve("todo")
  }

  companion object {
    const val NAME = "UniqueIdentifier"
  }
}
