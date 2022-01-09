package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AttributeTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel,
    experience: Int
) {
    val attributesWithSkills by viewModel.attributes.collectAsState()

    Column(modifier = modifier) {
        LazyColumn {
            attributesWithSkills.forEach { attributeWithSkills ->
                item {
                    AttributeView(
                        attribute = attributeWithSkills.attribute,
                        onIncreaseAttribute = { viewModel.increaseAttribute(it) },
                        onDecreaseAttribute = { viewModel.decreaseAttribute(it) },
                        canIncrease = attributeWithSkills.attribute.level < 20 &&
                                experience >= Attribute.UPGRADE_COSTS_FOR_LEVELS[attributeWithSkills.attribute.level]!!,
                        canDecrease = attributeWithSkills.attribute.level > 0,
                        onExpand = { viewModel.onExpand(attributeWithSkills.attribute.attributeId) },
                        expanded = attributeWithSkills.attribute.attributeId == viewModel.expandedAttributeId.value
                    )
                }

                if (attributeWithSkills.attribute.attributeId == viewModel.expandedAttributeId.value) {
                    items(attributeWithSkills.skills) { skillWithSpecs ->
                        SkillView(
                            skill = skillWithSpecs.skill,
                            onIncreaseSkill = {
                                viewModel.increaseSkill(it, attributeWithSkills.attribute.level)
                            },
                            onDecreaseSkill = { viewModel.decreaseSkill(it) },
                            canIncrease = skillWithSpecs.skill.level < 25 &&
                                    experience >= skillWithSpecs.skill.upgradeCost,
                            canDecrease = skillWithSpecs.skill.level > skillWithSpecs.skill.baseLevel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AttributeView(
    attribute: Attribute,
    onIncreaseAttribute: (Attribute) -> Unit,
    onDecreaseAttribute: (Attribute) -> Unit,
    canIncrease: Boolean,
    canDecrease: Boolean,
    onExpand: () -> Unit,
    expanded: Boolean
) {
    Card(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.large),
        contentColor = if (expanded) MaterialTheme.colors.background else MaterialTheme.colors.primary,
        backgroundColor = if (expanded) MaterialTheme.colors.primary else MaterialTheme.colors.background
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onExpand() }
                    .padding(start = 8.dp)
            ) {
                Text(modifier = Modifier.weight(1F), text = attribute.name)
                IconButton(
                    onClick = { onDecreaseAttribute(attribute) },
                    enabled = canDecrease,
                    content = {
                        Icon(Icons.Filled.Remove, contentDescription = "Odejmij")
                    }
                )
                Text(
                    attribute.level.toString(),
                    modifier = Modifier.width(20.dp),
                    textAlign = TextAlign.Center
                )
                IconButton(
                    onClick = { onIncreaseAttribute(attribute) },
                    enabled = canIncrease,
                    content = {
                        Icon(Icons.Filled.Add, contentDescription = "Dodaj")
                    }
                )
            }
            if (expanded) {
                Divider(color = MaterialTheme.colors.onPrimary)
                Text(modifier = Modifier.padding(8.dp), text = attribute.description)
            }
        }
    }
}

@Composable
fun SkillView(
    skill: Skill,
    onIncreaseSkill: (Skill) -> Unit,
    onDecreaseSkill: (Skill) -> Unit,
    canIncrease: Boolean,
    canDecrease: Boolean,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp, start = 16.dp)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.large)
            .padding(start = 8.dp),
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = skill.name, Modifier.weight(1F))
            IconButton(
                onClick = { onDecreaseSkill(skill) },
                enabled = canDecrease,
                content = {
                    Icon(Icons.Filled.Remove, contentDescription = "Odejmij")
                }
            )
            Text(skill.level.toString())
            IconButton(
                onClick = { onIncreaseSkill(skill) },
                enabled = canIncrease,
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Dodaj")
                }
            )
        }
    }
}