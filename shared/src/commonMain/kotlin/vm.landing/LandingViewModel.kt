import com.rickclephas.kmm.viewmodel.KMMViewModel
import domain.activationState.AppActivationState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LandingViewModel : KMMViewModel(), KoinComponent {

    private val appActivationState: AppActivationState by inject()

    fun activateApp() {
        appActivationState.setAppActivated()
    }
}