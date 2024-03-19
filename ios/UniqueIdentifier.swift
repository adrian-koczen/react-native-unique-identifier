import Foundation
import CloudKit

@objc(UniqueIdentifier)
class UniqueIdentifier: NSObject {
    @objc
    func getIcloudRecord(_ resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock) -> Void {
        CKContainer.default().fetchUserRecordID { (record, error) in
            if ((error) != nil) {
                return reject("error", "error", error)
            }
            
            if let recordName = record?.recordName {
                return resolve(recordName)
            }
            
            resolve("NO_ICLOUD_RECORD")
        }
    }


    @objc
    static func requiresMainQueueSetup() -> Bool {
        return false
    }
}
