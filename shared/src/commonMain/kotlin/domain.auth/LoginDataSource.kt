package domain.auth

import kotlinx.coroutines.flow.StateFlow

interface LoginDataSource {
    val isLoggedIn: StateFlow<Boolean?>
    suspend fun checkLoginState()
    suspend fun login(pin: String)
    fun logout()
}