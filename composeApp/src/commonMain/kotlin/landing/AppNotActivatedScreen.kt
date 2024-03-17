package landing

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AppNotActivatedScreen(
    onActivateClick: () -> Unit
) {
    Column {
        Text("App is not activated")
        Button(onClick = onActivateClick) {
            Text("Activate mes")
        }
    }

}