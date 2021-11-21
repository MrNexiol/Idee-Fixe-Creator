package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
        CharacterSheetList(
            characterList = characterList,
            navController = navController
        )
    }
}

@Composable
fun CharacterSheetList(
    characterList: List<CharacterSheet>,
    navController: NavController
) {
    LazyColumn {
        items(characterList) { characterSheet ->
            CharacterListItem(
                characterSheet = characterSheet,
                navController = navController
            )
        }
    }
}

@Composable
fun CharacterListItem(
    characterSheet: CharacterSheet,
    navController: NavController
) {
    Row(Modifier.clickable { navController.navigate(Screen.CharacterShowScreen.route) }) {
        Text(text = characterSheet.name)
    }
}