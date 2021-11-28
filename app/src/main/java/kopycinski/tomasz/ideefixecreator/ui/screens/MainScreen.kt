package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    var openDialog by remember { mutableStateOf(false) }

    LaunchedEffect(false) {
        viewModel.getUnfinished()
    }

    IdeeFixeCreatorTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(Screen.CharacterListScreen.route) }) {
                Text(text = "List")
            }
            Button(onClick = {
                viewModel.characterSheet?.let {
                    openDialog = true
                } ?: navController.navigate(Screen.CharacterCreateScreen.route)
            }) {
                Text(text = "Create")
            }
            if (openDialog) {
                AlertDialog(
                    title = {
                        Text(text = "Wykryto nie ukończoną kartę postaci")
                    },
                    text = {
                        Text(
                            text = "Wykryto kartę postaci która nie została ukończona, Utworzenie " +
                                    "nowej karty postaci usunie tą, która już istnieje. Czy chcesz" +
                                    " kontynuować?"
                        )
                    },
                    onDismissRequest = { openDialog = false },
                    dismissButton = {
                        Button(onClick = {
                            openDialog = false
                            navController.navigate(
                                Screen.CharacterCreateScreen.createRoute(
                                    viewModel.characterSheet!!.characterSheetId
                                )
                            )
                        }) {
                            Text(text = "Edytuj istniejącą kartę")
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            openDialog = false
                            viewModel.removeCharacterSheet()
                            navController.navigate(Screen.CharacterCreateScreen.route)
                        }) {
                            Text(text = "Utwórz nową kartę")
                        }
                    }
                )
            }
        }
    }
}