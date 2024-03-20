### Installation

```
yarn add react-native-unique-identifier
```
### Expo

Update app.json

```
"plugins": [["react-native-unique-identifier/plugin"]]
```
### Usage

| Function | Response | Platform | Description |
| :-------- | :------- | :------- | :------- |
| `getIosCloudRecord`      | `Promise<string>` | iOS | iCloud record |
| `getAndroidAccountName`      | `Promise<string>` | Android| google email name |
