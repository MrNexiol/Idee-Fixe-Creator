package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AdvantageTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val characterSheet by viewModel.characterSheet.collectAsState()
    val advantages by viewModel.advantages.collectAsState()
    val addedAdvantages by viewModel.addedAdvantageIds.collectAsState()

    Column(modifier = modifier) {
        Text(characterSheet.experience.toString())
        LazyColumn {
            items(advantages) { advantage ->
                val foundAdv = addedAdvantages.find { it.advantageId == advantage.advantageId }
                val level = foundAdv?.level ?: 0

                AdvantageView(advantage, level, characterSheet.experience) { cost, newLevel ->
                    viewModel.modifyAdvantage(advantage.advantageId, cost, newLevel, foundAdv)
                }
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

    Column(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .clip(CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
            .background(Color.Gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = advantage.name, modifier = Modifier.weight(1f))
            var costSum = -1
            advantage.costs.forEachIndexed { index, cost ->
                if (costSum >= 0) costSum += cost - advantage.costs[index - 1]
                val checked = index == level - 1
                if (checked) costSum = 0
                val realCost = if (advantage.costs.count() == 1) cost else costSum
                val enabled = (checked || level - 1 > index) || currentExp > realCost
                Checkbox(checked = checked, onCheckedChange = { onClick(cost, index + 1) }, enabled = enabled)
            }
        }
        if (expanded) Text(modifier = Modifier.padding(8.dp), text = advantage.description)
    }
}