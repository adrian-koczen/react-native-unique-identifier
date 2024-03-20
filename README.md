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
| `getiCloudRecord`      | `Promise<string>` | iOS | iCloud record |
| `getGoogleAccountName`      | `Promise<string>` | Android| google email name |
