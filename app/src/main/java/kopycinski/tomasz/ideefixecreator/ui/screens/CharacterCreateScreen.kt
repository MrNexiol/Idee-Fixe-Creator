package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun CharacterCreateScreen(
    viewModel: CharacterCreateViewModel = hiltViewModel()
) {
    LaunchedEffect(false) {
        viewModel.getCharacterSheet()
    }

    IdeeFixeCreatorTheme {
        Scaffold { contentPadding ->
            Form(
                Modifier
                    .padding(contentPadding)
                    .padding(8.dp),
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun Form(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val characterSheet by viewModel.characterSheet.collectAsState()

    Column(modifier = modifier) {
        OutlinedTextField(
            value = characterSheet.name,
            onValueChange = {
                viewModel.updateCharacterSheet(characterSheet.copy(name = it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Name")
            }
        )
        OutlinedTextField(
            value = characterSheet.surname,
            onValueChange = {
                viewModel.updateCharacterSheet(characterSheet.copy(surname = it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Surname")
            }
        )
        OutlinedTextField(
            value = characterSheet.gender,
            onValueChange = {
                viewModel.updateCharacterSheet(characterSheet.copy(gender = it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Gender")
            }
        )
        OutlinedTextField(
            value = characterSheet.nationality,
            onValueChange = {
                viewModel.updateCharacterSheet(characterSheet.copy(nationality = it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Nationality")
            }
        )
    }
}