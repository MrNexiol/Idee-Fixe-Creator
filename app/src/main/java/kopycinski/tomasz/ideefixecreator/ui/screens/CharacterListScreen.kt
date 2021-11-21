package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val characterList: List<CharacterSheet> by viewModel.getAll().collectAsState(listOf())

    IdeeFixeCreatorTheme {
        LazyColumn() {
            items(characterList) { characterSheet ->
                Text(text = characterSheet.name)
            }
        }
        Button(onClick = { navController.navigate(Screen.CharacterShowScreen.route) }) {
            Text(text = "Dummy character sheet")
        }
    }
}