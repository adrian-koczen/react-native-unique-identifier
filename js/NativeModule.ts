import { TurboModule, TurboModuleRegistry } from 'react-native'

export interface Spec extends TurboModule {
    getIcloudRecord(): Promise<string>,
    requiresMainQueueSetup(): boolean
}

export default TurboModuleRegistry.get<Spec>('UniqueIdentifier') as Spec | null
