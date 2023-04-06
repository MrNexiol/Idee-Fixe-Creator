package kopycinski.tomasz.ideefixecreator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kopycinski.tomasz.ideefixecreator.ui.screens.*
import kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen.CharacterCreateScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen.CharacterShowScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.debug.AttributesScreen
import kopycinski.tomasz.ideefixecreator.ui.screens.debug.CharacterSheetScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
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
            arguments = listOf(
                navArgument("characterSheetId") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) { backStackEntry ->
            var characterSheetId = backStackEntry.arguments?.getLong("characterSheetId")
            if (characterSheetId == -1L) {
                characterSheetId = null
            }
            CharacterCreateScreen(characterSheetId = characterSheetId)
        }

        composable(route = Screen.AttributesScreen.route) {
            AttributesScreen()
        }

        composable(route = Screen.CharacterSheetScreen.route) {
            CharacterSheetScreen()
        }
    }
}