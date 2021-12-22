package kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.ui.theme.IdeeFixeCreatorTheme
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterShowViewModel

@Composable
fun CharacterShowScreen(
    navController: NavController,
    characterSheetId: Long = 0,
    viewModel: CharacterShowViewModel = hiltViewModel()
) {
    val characterSheet by viewModel.characterSheet.collectAsState()
    val attributes by viewModel.attributes.collectAsState()
    val advantages by viewModel.advantages.collectAsState()

    LaunchedEffect(false) {
        viewModel.loadData(characterSheetId)
    }

    IdeeFixeCreatorTheme {
        Scaffold { contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(8.dp)
            ) {
                Text(text = characterSheet.name)
                LazyColumn {
                    attributes.forEach { attributeWithSkills ->
                        item {
                            Text(text = attributeWithSkills.attribute.name)
                        }
                        items(attributeWithSkills.skills) { skillWithSpecs ->
                            Text(text = skillWithSpecs.skill.name)
                        }
                    }
                    items(advantages) { advantage ->
                        Text(text = advantage.name)
                    }
                }
            }
        }
    }
}