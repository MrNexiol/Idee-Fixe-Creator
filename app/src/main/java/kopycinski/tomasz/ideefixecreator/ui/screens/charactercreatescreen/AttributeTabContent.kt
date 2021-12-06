package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.SkillWithSpecializations
import kopycinski.tomasz.ideefixecreator.ui.theme.parallelogram
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AttributeTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val attributesWithSkills by viewModel.attributes.collectAsState()
    val characterSheet by viewModel.characterSheet.collectAsState()

    Column {
        Text(text = characterSheet.experience.toString())
        LazyColumn(modifier = modifier) {
            items(attributesWithSkills) { attributeWithSkills ->
                AttributeView(
                    attribute = attributeWithSkills.attribute,
                    onIncreaseAttribute = { viewModel.increaseAttribute(it) },
                    onDecreaseAttribute = { viewModel.decreaseAttribute(it) },
                    canIncrease = attributeWithSkills.attribute.level < 20 &&
                            characterSheet.experience >= Attribute.UPGRADE_COSTS_FOR_LEVELS[attributeWithSkills.attribute.level]!!,
                    canDecrease = attributeWithSkills.attribute.level > 0,
                    onExpand = { viewModel.onExpand(attributeWithSkills.attribute.attributeId) },
                    expanded = attributeWithSkills.attribute.attributeId == viewModel.expandedAttributeId.value
                )
                if (attributeWithSkills.attribute.attributeId == viewModel.expandedAttributeId.value) {
                    SkillList(
                        skillsWithSpecializations = attributeWithSkills.skills,
                        onIncreaseSkill = {
                            viewModel.increaseSkill(
                                it,
                                attributeWithSkills.attribute.level
                            )
                        },
                        onDecreaseSkill = { viewModel.decreaseSkill(it) },
                        currentExperience = characterSheet.experience
                    )
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
    Column(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .clip(CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
            .background(Color.Gray)
    ) {
        val border = BorderStroke(1.dp, Color.Black)
        val shape = MaterialTheme.shapes.parallelogram

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.LightGray)
                .clickable { onExpand() }
                .padding(8.dp)
        ) {
            Text(
                modifier = Modifier.weight(1F),
                text = attribute.name,
            )
            Row(
                modifier = Modifier.border(border, shape = shape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { onDecreaseAttribute(attribute) },
                    enabled = canDecrease,
                    shape = shape,
                    border = border
                ) {
                    Text("-")
                }
                Text(attribute.level.toString())
                TextButton(
                    onClick = { onIncreaseAttribute(attribute) },
                    enabled = canIncrease,
                    shape = shape,
                    border = border
                ) {
                    Text("+")
                }
            }
        }
        if (expanded) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = attribute.description
            )
        }
    }
}

@Composable
fun SkillList(
    skillsWithSpecializations: List<SkillWithSpecializations>,
    onIncreaseSkill: (Skill) -> Unit,
    onDecreaseSkill: (Skill) -> Unit,
    currentExperience: Int
) {
    skillsWithSpecializations.forEach {
        SkillView(
            skill = it.skill,
            onIncreaseSkill = onIncreaseSkill,
            onDecreaseSkill = onDecreaseSkill,
            canIncrease = it.skill.level < 25 && currentExperience >= it.skill.upgradeCost,
            canDecrease = it.skill.level > it.skill.baseLevel
        )
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
    val border = BorderStroke(1.dp, Color.Black)
    val shape = MaterialTheme.shapes.parallelogram

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, bottom = 4.dp)
            .clip(CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
            .background(Color.DarkGray)
            .padding(8.dp)
    ) {
        Text(text = skill.name, Modifier.weight(1F))
        Row(
            modifier = Modifier.border(border, shape = shape),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = { onDecreaseSkill(skill) },
                enabled = canDecrease,
                shape = shape,
                border = border
            ) {
                Text("-")
            }
            Text(skill.level.toString())
            TextButton(
                onClick = { onIncreaseSkill(skill) },
                enabled = canIncrease,
                shape = shape,
                border = border
            ) {
                Text("+")
            }
        }
    }
}