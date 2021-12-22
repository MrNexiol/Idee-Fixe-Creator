package kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterShowViewModel

@Composable
fun StatsTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterShowViewModel
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Elo")
    }
}