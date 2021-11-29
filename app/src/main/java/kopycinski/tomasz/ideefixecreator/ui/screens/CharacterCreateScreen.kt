package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

const val INFO_TAB = 0
const val ATTRIBUTES_TAB = 1
const val SKILL_TAB = 2

@Composable
fun CharacterCreateScreen(
    viewModel: CharacterCreateViewModel = hiltViewModel()
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Info", "Attributes", "Skills")
    
    LaunchedEffect(false) {
        viewModel.getCharacterSheet()
    }

    IdeeFixeCreatorTheme {
        Scaffold { contentPadding ->
            Column {
                TabRow(selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = state == index,
                            onClick = { state = index }
                        )
                    }
                }
                when (state) {
                    INFO_TAB -> {
                        Form(
                            Modifier
                                .padding(contentPadding)
                                .padding(8.dp),
                            viewModel = viewModel
                        )
                    }
                    ATTRIBUTES_TAB -> {
                        Text(text = "Elo")
                    }
                    SKILL_TAB -> {
                        Text(text = "Siemanko")
                    }
                    else -> {}
                }
            }
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