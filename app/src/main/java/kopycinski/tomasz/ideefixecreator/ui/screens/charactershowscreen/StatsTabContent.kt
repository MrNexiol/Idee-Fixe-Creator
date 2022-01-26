package kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.ui.SectionContainer
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterShowViewModel

@Composable
fun StatsTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterShowViewModel
) {
    val advantages by viewModel.advantages.collectAsState()
    val attributes by viewModel.attributes.collectAsState()
    val skills by viewModel.skills.collectAsState()

    LazyColumn(
        modifier = modifier
    ) {
        // Advantages
        item {
            SectionContainer(
                modifier = Modifier.padding(top = 8.dp),
                label = "Zdolności"
            ) {
                if (advantages.isNotEmpty()) {
                    Column {
                        advantages.forEach {
                            Text(it.name)
                        }
                    }
                } else {
                    Text("Nie masz zdolności")
                }
            }
        }
        // Attributes
        item {
            if (attributes.isNotEmpty()) {
                SectionContainer(
                    label = "Atrybuty"
                ) {
                    Row(
                        Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AttributeView(attributes[0])
                            AttributeView(attributes[3])
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AttributeView(attributes[1])
                            AttributeView(attributes[4])
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AttributeView(attributes[2])
                            AttributeView(attributes[5])
                        }
                    }
                }
            }
        }
        // Skills
        item {
            SectionContainer(
                label = "Umiejętności"
            ) {
                Column {
                    skills.forEach {
                        Text("${it.level} - ${it.name}")
                    }
                }
            }
        }
    }
}

@Composable
fun AttributeView(attribute: Attribute) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = attribute.level.toString(),
                fontSize = 24.sp
            )
        }
        Text(attribute.name)
    }
}