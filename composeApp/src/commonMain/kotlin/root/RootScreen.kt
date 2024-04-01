package root

import LandingViewModel
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import demo.KMMDemoScreen
import landing.AppNotActivatedScreen
import login.LoginScreen
import org.koin.androidx.compose.getViewModel
import vm.login.LoginViewModel
import vm.root.RootState
import vm.root.RootViewModel

@Composable
fun RootScreen(
    viewModel: RootViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsState()
    when (state) {
        is RootState.ApplicationLoggedIn -> {
            KMMDemoScreen()
        }

        is RootState.ApplicationNotLoggedIn -> {
            val loginViewModel: LoginViewModel = getViewModel()
            val loginUiState by loginViewModel.state.collectAsState()
            LoginScreen(
                loginUiState,
                onPinUpdate = { loginViewModel.onPinUpdate(it) },
                onOkClicked = { loginViewModel.onOkButtonClicked() })
        }

        RootState.ApplicationNotActivated -> {
            val landingViewModel: LandingViewModel = getViewModel()
            AppNotActivatedScreen(onActivateClick = { landingViewModel.activateApp() })
        }

        RootState.Loading -> {
            Text("Loading TODO")
        }
    }
}
