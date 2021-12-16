package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.background
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
        Text(text = characterSheet.experience.toString())
        LazyColumn {
            items(addedAdvantages) { addedAdvantage ->
                Text(text = addedAdvantage.toString())
            }
        }
        LazyColumn {
            items(advantages) { advantage ->
                val foundAdv = addedAdvantages.find { it.advantageId == advantage.advantageId }
                val level = foundAdv?.level ?: 0

                AdvantageView(advantage, level) { cost, newLevel ->
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
    onClick: (Int, Int) -> Unit
) {
    Row(
        Modifier
            .padding(bottom = 4.dp)
            .clip(CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
            .background(Color.Gray)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = advantage.name, modifier = Modifier.weight(1f))
        advantage.costs.forEachIndexed { index, cost ->
            val checked = index == level - 1
            Checkbox(checked = checked, onCheckedChange = { onClick(cost, index + 1) })
        }
    }
}