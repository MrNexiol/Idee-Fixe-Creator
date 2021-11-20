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
            MainScreen(navController)
        }
        composable(route = Screen.CharacterListScreen.route) {
            CharacterListScreen(navController)
        }
        composable(route = Screen.CharacterCreateScreen.route) {
            CharacterCreateScreen(navController)
        }
        composable(route = Screen.CharacterEditScreen.route) {
            CharacterEditScreen(navController)
        }
    }
}