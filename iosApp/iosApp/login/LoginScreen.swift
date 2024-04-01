import SwiftUI
import Shared
import KMMViewModelCore
import KMMViewModelSwiftUI

struct LoginScreen: View {
    @StateViewModel var viewModel = LoginViewModel()
    var body: some View {
        let state = viewModel.state
        switch state{
        case is LoginState.Ready:
            let readyState = state as! LoginState.Ready
            VStack {
                SecureField("Pin", text: Binding<String>(
                    get: { readyState.pin},
                    set: { viewModel.onPinUpdate(value: $0)}
                ))
                Button("Ok", action: { viewModel.onOkButtonClicked()})
            }
        default:
            Text("Loading")
            
        }

    }
}



struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoginScreen()
    }
}
