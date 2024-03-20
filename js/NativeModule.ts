import { TurboModule, TurboModuleRegistry } from 'react-native'
interface Spec extends TurboModule {
    getAndroidAccountName(message: string): Promise<string>,
    getIcloudRecord(): Promise<string>,
    requiresMainQueueSetup(): boolean
}

export default TurboModuleRegistry.get<Spec>('UniqueIdentifier') as Spec || null
