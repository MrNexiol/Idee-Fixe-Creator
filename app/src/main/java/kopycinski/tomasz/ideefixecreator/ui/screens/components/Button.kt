package kopycinski.tomasz.ideefixecreator.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonMain(
    modifier: Modifier = Modifier,
    text: String = "Click me",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.primary
        ),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
        modifier = modifier.fillMaxWidth().padding(bottom = 4.dp)
    ) {
        Text(text)
    }
}