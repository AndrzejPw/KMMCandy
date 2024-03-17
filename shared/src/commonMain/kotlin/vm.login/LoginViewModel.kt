package vm.login

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import domain.auth.LoginDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

private const val MIN_PIN_LENGTH = 4

class LoginViewModel : KMMViewModel(), KoinComponent {

    private val loginDataSource: LoginDataSource by inject()

    private val pin = MutableStateFlow("")
    private val isLoading = MutableStateFlow(false)

    @NativeCoroutinesState
    val state = combine(pin, isLoading) { pin, loading ->
        if (loading) {
            LoginState.Loading
        } else {
            LoginState.Ready(
                pin = pin,
                okActive = pin.length >= MIN_PIN_LENGTH,
            )
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        LoginState.Loading
    )


    fun onPinUpdate(value: String) {
        pin.value = value
    }

    fun onOkButtonClicked() {
        viewModelScope.coroutineScope.launch {
            isLoading.value = true
            delay(2000)
            loginDataSource.login(pin.value)
        }
    }
}
