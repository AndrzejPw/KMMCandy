import SwiftUI
import Shared
import KMMViewModelCore
import KMMViewModelSwiftUI

struct RootScreen: View {
    @StateViewModel var viewModel = RootViewModel()
    
    var body: some View {
        VStack {
            switch viewModel.state {
            case is RootState.ApplicationNotActivated: AppNotActivatedScreen()
            case is RootState.ApplicationNotLoggedIn:
                LoginScreen()
            case is RootState.ApplicationLoggedIn:
                KMMDemoScreen()
            case is RootState.Loading:
                Text("Root Loading")
            default:
                Text("Loading")
            }
        }
    }
}

struct RootScreen_Previews: PreviewProvider {
    static var previews: some View {
        RootScreen()
    }
}
