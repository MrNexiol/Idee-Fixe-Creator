package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.R
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

const val INFO_TAB = 0
const val ATTRIBUTES_TAB = 1
const val ADVANTAGE_TAB = 2

@Composable
fun CharacterCreateScreen(
    characterSheetId: Long?,
    viewModel: CharacterCreateViewModel = hiltViewModel()
) {
    val experience by viewModel.experience.collectAsState()
    var state by remember { mutableStateOf(INFO_TAB) }
    val titles = listOf(
        stringResource(R.string.info_tab),
        stringResource(R.string.attributes_tab),
        stringResource(R.string.advantages_tab)
    )
    
    LaunchedEffect(false) {
        viewModel.loadData(characterSheetId)
    }

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
        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 8.dp, end = 8.dp)
                .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.medium)
                .padding(8.dp),
            text = "$experience PP",
            color = MaterialTheme.colors.primary
        )
        when (state) {
            INFO_TAB -> {
                InfoTabContent(
                    Modifier
                        .padding(8.dp),
                    viewModel = viewModel
                )
            }
            ATTRIBUTES_TAB -> {
                AttributeTabContent(
                    Modifier
                        .padding(8.dp),
                    viewModel = viewModel,
                    experience = experience
                )
            }
            ADVANTAGE_TAB -> {
                AdvantageTabContent(
                    Modifier
                        .padding(8.dp),
                    viewModel = viewModel,
                    experience = experience
                )
            }
            else -> {}
        }
    }
}