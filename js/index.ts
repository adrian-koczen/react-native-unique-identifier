import NativeModule from './NativeModule'

const getiCloudRecord = NativeModule.getIcloudRecord
const getGoogleAccountName = NativeModule.getAndroidAccountName
const getAdvertisingInfo = NativeModule.getAdvertisingInfo

export {
    getiCloudRecord,
    getGoogleAccountName,
    getAdvertisingInfo
}
