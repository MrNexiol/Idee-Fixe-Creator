package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme

@Composable
fun CharacterCreateScreen(navController: NavController) {
    IdeeFixeCreatorTheme {
        Button(onClick = { navController.navigate(Screen.CharacterListScreen.route) }) {
            Text(text = "Save")
        }
    }
}