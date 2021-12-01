package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AttributeTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val attributes by viewModel.attributes.collectAsState()
    Column(modifier = modifier) {
        attributes.forEach { attribute ->
            Attribute(
                attribute = attribute,
                onChange = { viewModel.updateAttribute(it) }
            )
        }
    }
}

@Composable
fun Attribute(
    attribute: Attribute,
    onChange: (Attribute) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = attribute.name)
        Text(text = attribute.level.toString())
        Row {
            Button(onClick = { onChange(attribute.copy(level = attribute.level - 1)) }) {
                Text(text = "-")
            }
            Button(onClick = { onChange(attribute.copy(level = attribute.level + 1)) }) {
                Text(text = "+")
            }
        }
    }
}