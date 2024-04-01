package di

import LandingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vm.login.LoginViewModel
import vm.root.RootViewModel

val appModule = module {
    viewModel { RootViewModel() }
    viewModel { LoginViewModel() }
    viewModel { LandingViewModel() }
}