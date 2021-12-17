package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme

@Composable
fun CharacterShowScreen(
    navController: NavController,
    characterSheetId: Long = 0
) {
    IdeeFixeCreatorTheme {
        Scaffold { contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(8.dp)
            ) {
                Text(text = "Testowe Id to: $characterSheetId")
                Button(onClick = { navController.navigate(Screen.CharacterEditScreen.route) }) {
                    Text(text = "Edit")
                }
            }
        }
    }
}