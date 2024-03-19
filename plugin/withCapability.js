const { withEntitlementsPlist } = require('expo/config-plugins')

module.exports = function withCapability(config) {
    return withEntitlementsPlist(config, async (newConfig) => {
        const entitlements = newConfig.modResults

        entitlements["com.apple.developer.icloud-container-identifiers"] = [`iCloud.${config.ios.bundleIdentifier}`]
        entitlements["com.apple.developer.icloud-services"] = ["CloudKit"]
    
        return newConfig
    })
}
