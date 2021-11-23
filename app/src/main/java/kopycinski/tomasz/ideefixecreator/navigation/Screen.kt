package kopycinski.tomasz.ideefixecreator.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object CharacterListScreen : Screen("character_list_screen")
    object CharacterShowScreen : Screen("character_show_screen/{characterSheetId}") {
        fun createRoute(characterSheetId: Long) = "character_show_screen/$characterSheetId"
    }
    object CharacterCreateScreen : Screen("character_create_screen")
    object CharacterEditScreen : Screen("character_edit_screen")
}
