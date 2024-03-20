import NativeModule from './NativeModule'

const getiCloudRecord = NativeModule.getIcloudRecord
const getGoogleAccountName = NativeModule.getAndroidAccountName

export {
    getiCloudRecord,
    getGoogleAccountName
}
