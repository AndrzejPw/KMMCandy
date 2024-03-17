package org.ab

import KMMDemoScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    when (val uiState = state) {
        is RootState.ApplicationActivated -> {
            if (uiState.loggedIn) {
                KMMDemoScreen()
            } else {
                val loginViewModel: LoginViewModel = getViewModel()
                val loginUiState by loginViewModel.state.collectAsState()
                LoginScreen(
                    loginUiState,
                    onPinUpdate = { loginViewModel.onPinUpdate(it) },
                    onOkClicked = { loginViewModel.onOkButtonClicked() })
            }
        }

        RootState.ApplicationNotActivated -> {

            AppNotActivatedScreen(onActivateClick = { viewModel.activateApp() })
        }

        RootState.Loading -> {

        }
    }
}
