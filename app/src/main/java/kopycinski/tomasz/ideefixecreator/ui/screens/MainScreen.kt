package kopycinski.tomasz.ideefixecreator.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.R
import kopycinski.tomasz.ideefixecreator.navigation.Screen

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
            OutlinedButton(
                onClick = { navController.navigate(Screen.CharacterListScreen.route) },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                ),
                border = BorderStroke(2.dp, MaterialTheme.colors.primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                Text(stringResource(R.string.list_button))
            }
            Button(
                onClick = { navController.navigate(Screen.CharacterCreateScreen.route) },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                ),
                border = BorderStroke(2.dp, MaterialTheme.colors.primary)
            ) {
                Text(stringResource(R.string.create_button))
            }
        }
    }
}