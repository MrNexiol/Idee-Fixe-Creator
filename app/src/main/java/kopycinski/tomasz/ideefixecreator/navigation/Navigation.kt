package kopycinski.tomasz.ideefixecreator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kopycinski.tomasz.ideefixecreator.ui.screens.CharacterCreateScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.CharacterEditScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.CharacterListScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
        composable(route = Screen.CharacterListScreen.route) {
            CharacterListScreen()
        }
        composable(route = Screen.CharacterCreateScreen.route) {
            CharacterCreateScreen()
        }
        composable(route = Screen.CharacterEditScreen.route) {
            CharacterEditScreen()
        }
    }
}