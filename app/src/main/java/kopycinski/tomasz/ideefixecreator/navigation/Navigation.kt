package kopycinski.tomasz.ideefixecreator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kopycinski.tomasz.ideefixecreator.ui.screens.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            route = Screen.CharacterShowScreen.route,
            arguments = listOf(
                navArgument("characterSheetId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val characterSheetId = backStackEntry.arguments?.getLong("characterSheetId")
            requireNotNull(characterSheetId) { "characterSheetId parameter not found" }
            CharacterShowScreen(navController = navController, characterSheetId = characterSheetId)
        }
        composable(route = Screen.CharacterListScreen.route) {
            CharacterListScreen(navController)
        }
        composable(
            route = Screen.CharacterCreateScreen.route,
            arguments = listOf(navArgument("characterSheetId") { defaultValue = -1L })
        ) { backStackEntry ->
            CharacterCreateScreen(backStackEntry.arguments!!.getLong("characterSheetId"))
        }
        composable(route = Screen.CharacterEditScreen.route) {
            CharacterEditScreen(navController)
        }
    }
}