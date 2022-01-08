package kopycinski.tomasz.ideefixecreator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SectionContainer(
    modifier: Modifier = Modifier,
    label: String,
    content: @Composable () -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.large)
    ) {
        Column() {
            Text(
                text = label,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .padding(8.dp)
            )
            Surface(
                content = content,
                contentColor = MaterialTheme.colors.primary,
                color = MaterialTheme.colors.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}