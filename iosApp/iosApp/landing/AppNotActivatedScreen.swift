import SwiftUI
import Shared
import KMMViewModelCore
import KMMViewModelSwiftUI

struct AppNotActivatedScreen: View {
    
    @StateViewModel var viewModel = LandingViewModel()
    
    var body: some View {
        VStack{
            Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            Button("Activate me", action: { viewModel.activateApp() })
        }
        
    }
}

struct AppNotActivatedScreen_Previews: PreviewProvider {
    static var previews: some View {
        AppNotActivatedScreen()
    }
}
