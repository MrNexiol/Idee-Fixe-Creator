package kopycinski.tomasz.ideefixecreator.navigation

import androidx.annotation.StringRes
import kopycinski.tomasz.ideefixecreator.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object MainScreen : Screen("main_screen", R.string.main_screen)
    object CharacterListScreen : Screen("character_list_screen", R.string.character_list_screen)
    object CharacterShowScreen : Screen("character_show_screen", R.string.character_show_screen)
    object CharacterCreateScreen : Screen("character_create_screen", R.string.character_create_screen)
    object CharacterEditScreen : Screen("character_edit_screen", R.string.character_edit_screen)
}
