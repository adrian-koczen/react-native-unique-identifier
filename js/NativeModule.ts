import { TurboModule, TurboModuleRegistry } from 'react-native'
interface Spec extends TurboModule {
    getAndroidAccountName(message: string): Promise<string>,
    getIcloudRecord(): Promise<string>,
    requiresMainQueueSetup(): boolean,
    getAdvertisingInfo(): Promise<string>
}

export default TurboModuleRegistry.get<Spec>('UniqueIdentifier') as Spec || null
