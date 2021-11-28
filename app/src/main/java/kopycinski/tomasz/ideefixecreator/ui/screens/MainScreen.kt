package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
                    navController.navigate(Screen.CharacterCreateScreen.createRoute(it.characterSheetId))
                } ?: navController.navigate(Screen.CharacterCreateScreen.route)
            }) {
                Text(text = "Create")
            }
        }
    }
}