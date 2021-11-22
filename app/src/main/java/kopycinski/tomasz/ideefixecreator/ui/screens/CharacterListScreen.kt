package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        Scaffold { contentPadding ->
            CharacterSheetList(
                characterList = characterList,
                navController = navController,
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CharacterSheetList(
    characterList: List<CharacterSheet>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
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
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp)
        .clickable { navController.navigate(Screen.CharacterShowScreen.route) },
        elevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .size(40.dp)
                    .background(Color.Gray))
            Column {
                Text(text = characterSheet.fullName())
            }
            Text(text = characterSheet.experience.toString())
        }
    }
}