package vm.login

sealed class LoginState {
    object Loading : LoginState()
    data class Ready(
        val pin: String = "",
        val okActive: Boolean = false,
    ) : LoginState()
}

