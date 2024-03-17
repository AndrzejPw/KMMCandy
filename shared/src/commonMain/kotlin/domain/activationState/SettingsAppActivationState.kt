package domain.activationState

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsAppActivationState : AppActivationState {
    private val settings = Settings()
    private val _activationState =
        MutableStateFlow(settings.getBoolean("isActive", defaultValue = false))
    override val activationState = _activationState.asStateFlow()

    override fun setAppActivated() {
        settings["isActive"] = true
        _activationState.value = true
    }
}