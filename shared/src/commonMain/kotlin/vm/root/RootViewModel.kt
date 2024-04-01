@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package vm.root

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import domain.activationState.AppActivationState
import domain.auth.LoginDataSource
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class RootViewModel : KMMViewModel(), KoinComponent {
    private val appActivationState: AppActivationState by inject()
    private val loginDataSource: LoginDataSource by inject()

    init {
        viewModelScope.coroutineScope.launch {
            loginDataSource.checkLoginState()
        }
    }

    @NativeCoroutinesState
    val state =
        combine(
            appActivationState.activationState,
            loginDataSource.isLoggedIn
        ) { isActivated, isLoggedIn ->
            if (isActivated) {
                if (isLoggedIn == null) {
                    RootState.Loading
                } else if (isLoggedIn) {
                    RootState.ApplicationLoggedIn
                } else {
                    RootState.ApplicationNotLoggedIn
                }
            } else {
                RootState.ApplicationNotActivated
            }

        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), RootState.Loading)
}

sealed class RootState {
    object Loading : RootState()
    object ApplicationNotActivated : RootState()
    object ApplicationLoggedIn : RootState()
    object ApplicationNotLoggedIn : RootState()
}
