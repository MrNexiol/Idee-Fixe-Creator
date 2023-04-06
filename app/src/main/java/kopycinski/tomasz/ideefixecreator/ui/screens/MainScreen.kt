package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.R
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.ui.screens.components.ButtonMain

@Composable
fun MainScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMain(text = stringResource(R.string.list_button)) {
                navController.navigate(Screen.CharacterListScreen.route)
            }

            ButtonMain(text = stringResource(R.string.create_button)) {
                navController.navigate(Screen.CharacterCreateScreen.route)
            }

            ButtonMain(text = "Lista atrybutów") {
                navController.navigate(Screen.AttributesScreen.route)
            }

            ButtonMain(text = "Postaci punkty") {
                navController.navigate(Screen.CharacterSheetScreen.route)
            }
        }
    }
}