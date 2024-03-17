package org.ab

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vm.login.LoginViewModel
import vm.root.RootViewModel

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}

val appModule = module {
    viewModel { RootViewModel() }
    viewModel { LoginViewModel() }
}