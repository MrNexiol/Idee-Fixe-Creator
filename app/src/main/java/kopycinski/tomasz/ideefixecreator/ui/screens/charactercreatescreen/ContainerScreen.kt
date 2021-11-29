package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

const val INFO_TAB = 0
const val ATTRIBUTES_TAB = 1
const val SKILL_TAB = 2

@Composable
fun CharacterCreateScreen(
    viewModel: CharacterCreateViewModel = hiltViewModel()
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Info", "Attributes", "Skills")
    
    LaunchedEffect(false) {
        viewModel.getCharacterSheet()
    }

    IdeeFixeCreatorTheme {
        Scaffold { contentPadding ->
            Column {
                TabRow(selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = state == index,
                            onClick = { state = index }
                        )
                    }
                }
                when (state) {
                    INFO_TAB -> {
                        InfoTabContent(
                            Modifier
                                .padding(contentPadding)
                                .padding(8.dp),
                            viewModel = viewModel
                        )
                    }
                    ATTRIBUTES_TAB -> {
                        AttributeTabContent(viewModel = viewModel)
                    }
                    SKILL_TAB -> {
                        SkillTabContent(viewModel = viewModel)
                    }
                    else -> {}
                }
            }
        }
    }
}