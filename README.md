### Installation

```
yarn add react-native-unique-identifier
```
### Expo

Update app.json

```
"plugins": [["react-native-unique-identifier/plugin"]]
```
### Bare react native
1. Open project in XCode
2. Signing & Capabilities
3. Click "+ Capability" button
4. Search and select iCloud (now you should see a new capability in "Signing & Capabilities" list)
6. Check CloudKit checkbox in services 
7. Add app bundle name using "+" button in Containers

### Usage

| Function | Response | Platform | Description |
| :-------- | :------- | :------- | :------- |
| `getiCloudRecord`      | `Promise<string>` | iOS | iCloud record |
| `getGoogleAccountName`      | `Promise<string>` | Android| google email name |
