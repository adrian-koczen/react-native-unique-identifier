package com.uniqueidentifier

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class UniqueIdentifierPackage : TurboReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? =
        if (name == UniqueIdentifierModule.NAME) {
            UniqueIdentifierModule(reactContext)
        } else {
            null
        }

    override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
        mapOf(
            UniqueIdentifierModule.NAME to ReactModuleInfo(
            UniqueIdentifierModule.NAME,
            UniqueIdentifierModule.NAME,
            false, // canOverrideExistingModule
            false, // needsEagerInit
            true, // hasConstants
            false, // isCxxModule
            true // isTurboModule
          )
        )
    }
}
