package di

import domain.activationState.AppActivationState
import domain.activationState.SettingsAppActivationState
import domain.auth.authModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(), authModule())
    }

//for iOS
fun initKoin() = initKoin { }

fun commonModule() = module {
    single<AppActivationState> { SettingsAppActivationState() }

}