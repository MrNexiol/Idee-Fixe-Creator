package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kopycinski.tomasz.ideefixecreator.R
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun InfoTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val characterSheet by viewModel.characterSheet.collectAsState()

    Column(modifier = modifier) {
        OutlinedTextField(
            value = characterSheet.surname,
            onValueChange = { viewModel.updateCharacterSheet(characterSheet.copy(surname = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.surname)) }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = characterSheet.names,
            onValueChange = { viewModel.updateCharacterSheet(characterSheet.copy(names = it)) },
            label = { Text(stringResource(R.string.names)) }
        )
        OutlinedTextField(
            value = characterSheet.gender,
            onValueChange = { viewModel.updateCharacterSheet(characterSheet.copy(gender = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.gender)) }
        )
        OutlinedTextField(
            value = characterSheet.nationality,
            onValueChange = { viewModel.updateCharacterSheet(characterSheet.copy(nationality = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.nationality)) }
        )
    }
}