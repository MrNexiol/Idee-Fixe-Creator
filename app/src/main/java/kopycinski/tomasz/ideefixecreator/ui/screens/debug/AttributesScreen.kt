package kopycinski.tomasz.ideefixecreator.ui.screens.debug

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.ui.screens.components.Statistic
import kopycinski.tomasz.ideefixecreator.viewmodel.DebugViewModel

@Composable
fun AttributesScreen(
    viewModel: DebugViewModel = hiltViewModel()
) {
    val listOfAll by viewModel.attrWithSkills

    LazyColumn {
        for (element in listOfAll) {
            item {
                Statistic(statistic = element.attributeNEW)
            }

            items(element.skillList) {
                Statistic(statistic = it, tabLevel = 1)
            }
        }
    }
}