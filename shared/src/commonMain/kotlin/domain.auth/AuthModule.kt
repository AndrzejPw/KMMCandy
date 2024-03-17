package domain.auth

import org.koin.dsl.module

fun authModule() = module {
    single<LoginDataSource> { FakeLoginDataSource() }
}