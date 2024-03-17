package domain.activationState

import kotlinx.coroutines.flow.StateFlow

interface AppActivationState {
    val activationState: StateFlow<Boolean>
    fun setAppActivated()

}