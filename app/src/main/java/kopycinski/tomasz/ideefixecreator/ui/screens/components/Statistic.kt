package kopycinski.tomasz.ideefixecreator.ui.screens.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.recent.Statistic

@Composable
fun Statistic(
    statistic: Statistic,
    tabLevel: Int = 0
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .then(if (tabLevel != 0) Modifier.padding(start = 8.dp) else Modifier)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.large),
        contentColor = if (expanded) MaterialTheme.colors.background else MaterialTheme.colors.primary,
        backgroundColor = if (expanded) MaterialTheme.colors.primary else MaterialTheme.colors.background
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(8.dp)
            ) {
                Text(modifier = Modifier.weight(1F), text = statistic.name)
            }
            if (expanded) {
                Divider(color = MaterialTheme.colors.onPrimary)
                Text(modifier = Modifier.padding(8.dp), text = statistic.description)
            }
        }
    }
}