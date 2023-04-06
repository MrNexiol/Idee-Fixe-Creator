package kopycinski.tomasz.ideefixecreator.ui.screens.debug

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.ui.screens.components.Statistic
import kopycinski.tomasz.ideefixecreator.viewmodel.DebugViewModel

@Composable
fun CharacterSheetScreen(
    viewModel: DebugViewModel = hiltViewModel()
) {
    val listOfAll by viewModel.attrWithLevels

    LazyColumn {
        for (element in listOfAll) {
            item {
                Statistic(statistic = element.attributeNEW, currentLevel = element.junctionTable.currentLevel)
            }
        }
    }
}