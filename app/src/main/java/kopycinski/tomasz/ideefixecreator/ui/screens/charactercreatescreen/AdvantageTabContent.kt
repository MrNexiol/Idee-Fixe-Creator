package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AdvantageTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel,
    experience: Int
) {
    val advantages by viewModel.advantages.collectAsState()
    val addedAdvantages by viewModel.addedAdvantages.collectAsState()

    LazyColumn(modifier = modifier) {
        items(advantages) { advantage ->
            val foundAdv = addedAdvantages.find { it.advantageId == advantage.advantageId }
            val level = foundAdv?.level ?: -1

            AdvantageView(advantage, level, experience) { cost, newLevel ->
                viewModel.modifyAdvantage(advantage.advantageId, cost, newLevel, foundAdv)
            }
        }
    }
}

@Composable
fun AdvantageView(
    advantage: Advantage,
    level: Int,
    currentExp: Int,
    onClick: (Int, Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.large),
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Text(text = advantage.name, modifier = Modifier.weight(1f))
                var checkedLevel = -1
                advantage.costs.forEachIndexed { index, cost ->
                    if (index == level) checkedLevel = level
                    val enabled =
                        (index == level || level > index) || currentExp > advantage.calculateCost(
                            checkedLevel,
                            index
                        )
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(20.dp)
                            .padding(start = 4.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(if (index == level) MaterialTheme.colors.primary else MaterialTheme.colors.background)
                            .border(
                                2.dp,
                                (if (enabled) MaterialTheme.colors.primary else MaterialTheme.colors.secondary)
                            )
                            .clickable {
                                if (enabled) onClick(cost, index)
                            }
                    )
                }
            }
            if (expanded) {
                Divider(color = MaterialTheme.colors.primary)
                Text(modifier = Modifier.padding(12.dp), text = advantage.description)
            }
        }
    }
}