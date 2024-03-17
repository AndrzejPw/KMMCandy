package login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import vm.login.LoginState


@Composable
fun LoginScreen(
    state: LoginState,
    onPinUpdate: (String) -> Unit,
    onOkClicked: () -> Unit
) {

    when (state) {
        LoginState.Loading -> CircularProgressIndicator()
        is LoginState.Ready -> LoginScreen(state, onPinUpdate, onOkClicked)
    }

}

@Composable
fun LoginScreen(
    state: LoginState.Ready,
    onPinUpdate: (String) -> Unit,
    onOkClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login Screen",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = state.pin,
            onValueChange = onPinUpdate,
            singleLine = true,
            label = { Text("Pin") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onOkClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            enabled = state.okActive
        ) {
            Text("Log In")
        }

    }
}

@Preview
@Composable
fun PreviewPinContent() {
    LoginScreen(
        state = LoginState.Ready(pin = "1234", okActive = true),
        onOkClicked = {},
        onPinUpdate = {})
}
