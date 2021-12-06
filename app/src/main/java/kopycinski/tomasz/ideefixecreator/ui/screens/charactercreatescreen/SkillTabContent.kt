package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun SkillTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    Text(text = "Skill")
}