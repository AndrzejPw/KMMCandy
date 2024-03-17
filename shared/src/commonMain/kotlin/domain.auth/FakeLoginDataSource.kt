package domain.auth

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeLoginDataSource : LoginDataSource {

    private val _isLoggedIn = MutableStateFlow<Boolean?>(null)
    override val isLoggedIn = _isLoggedIn.asStateFlow()

    override suspend fun checkLoginState() {
        _isLoggedIn.value = false
    }

    override suspend fun login(pin: String) {
        _isLoggedIn.value = true
    }

    override fun logout() {
        _isLoggedIn.value = false
    }
}