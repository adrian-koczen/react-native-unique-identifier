const { withPlugins } = require('expo/config-plugins')
const withCapability = require('./withCapability')

module.exports = function withChain(config) {
    return withPlugins(config, [
        [withCapability]
    ])
}
