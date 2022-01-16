package kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kopycinski.tomasz.ideefixecreator.R
import kopycinski.tomasz.ideefixecreator.navigation.Screen
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterShowViewModel

const val STATS_TAB = 0
const val INFO_TAB = 1

@Composable
fun CharacterShowScreen(
    navController: NavController,
    characterSheetId: Long,
    viewModel: CharacterShowViewModel = hiltViewModel()
) {
    var state by remember { mutableStateOf(STATS_TAB) }
    val titles = listOf(
        stringResource(R.string.stats_tab),
        stringResource(R.string.info_tab)
    )

    LaunchedEffect(false) {
        viewModel.loadData(characterSheetId)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.CharacterCreateScreen.createRoute(characterSheetId)) }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edycja")
            }
        },
        topBar = {
            TabRow(selectedTabIndex = state) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = state == index,
                        onClick = { state = index }
                    )
                }
            }
        }
    ) { contentPadding ->
        Column {
            when (state) {
                STATS_TAB -> StatsTabContent(
                    Modifier
                        .padding(contentPadding)
                        .padding(start = 8.dp, end = 8.dp),
                    viewModel = viewModel
                )
                INFO_TAB -> InfoTabContent(
                    Modifier
                        .padding(contentPadding)
                        .padding(8.dp),
                    viewModel = viewModel
                )
                else -> {}
            }
        }
    }
}