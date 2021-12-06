package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.SkillWithSpecializations
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
                        onDecreaseSkill = { viewModel.decreaseSkill(it) }
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
    onExpand: () -> Unit,
    expanded: Boolean
) {
    Column(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .clip(CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp))
            .background(Color.Gray)
    ) {
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
            Button(
                enabled = attribute.level > 0,
                onClick = { onDecreaseAttribute(attribute) }
            ) {
                Text(text = "-")
            }
            Text(text = attribute.level.toString())
            Button(
                enabled = attribute.level < 20,
                onClick = { onIncreaseAttribute(attribute) }
            ) {
                Text(text = "+")
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
    onDecreaseSkill: (Skill) -> Unit
) {
    skillsWithSpecializations.forEach {
        SkillView(
            skill = it.skill,
            onIncreaseSkill = onIncreaseSkill,
            onDecreaseSkill = onDecreaseSkill,
            canIncrease = it.skill.level < 25,
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, bottom = 4.dp)
            .clip(CutCornerShape(4.dp, 0.dp, 4.dp, 0.dp))
            .background(Color.DarkGray)
            .padding(4.dp)
    ) {
        Text(text = skill.name, Modifier.weight(1F))
        Button(
            enabled = canDecrease,
            onClick = { onDecreaseSkill(skill) }
        ) {
            Text(text = "-")
        }
        Text(text = skill.level.toString())
        Button(
            enabled = canIncrease,
            onClick = { onIncreaseSkill(skill) }
        ) {
            Text(text = "+")
        }
    }
}