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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(1.dp, Color.LightGray, MaterialTheme.shapes.large)
                    .padding(8.dp)
            ) {
                advantages.forEach {
                    Text(it.name)
                }
            }
        }
        // Attributes
        item {
            if (attributes.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.LightGray, MaterialTheme.shapes.large)
                        .padding(top = 16.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
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
        // Skills
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray, MaterialTheme.shapes.large)
                    .padding(8.dp)
            ) {
                skills.forEach {
                    Text("${it.level} - ${it.name}")
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
                .border(1.dp, Color.LightGray, MaterialTheme.shapes.large),
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