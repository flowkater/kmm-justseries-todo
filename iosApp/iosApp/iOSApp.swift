import SwiftUI
import shared

@main
struct iOSApp: App {
    let sdk = TodoSDK(databaseDriverFactory: DatabaseDriverFactory())
	var body: some Scene {
		WindowGroup {
			ContentView(viewModel: .init(service: sdk))
		}
	}
}
