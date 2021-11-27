package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun CharacterCreateScreen(
    navController: NavController,
    viewModel: CharacterCreateViewModel = hiltViewModel()
) {
    val characterSheet by viewModel.characterSheet.collectAsState()

    IdeeFixeCreatorTheme {
        Column {
            Text(text = "Character sheet name is: ${characterSheet.name}")
            Button(onClick = { navController.navigate(Screen.CharacterListScreen.route) }) {
                Text(text = "Navigate")
            }
            Button(onClick = { viewModel.insertCharacterSheet(
                CharacterSheet(
                    name = "Siergiej",
                    surname = "Repnin",
                    gender = "Mężczyzna",
                    nationality = "Rosjanin"
                ))
            }) {
                Text(text = "Save")
            }
        }
    }
}