package kopycinski.tomasz.ideefixecreator.ui.screens.charactercreatescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import kopycinski.tomasz.ideefixecreator.database.entity.AttributeWithSkillsAndSpecializations
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.entity.SkillWithSpecializations
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterCreateViewModel

@Composable
fun AttributeTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterCreateViewModel
) {
    val attributes by viewModel.attributes.collectAsState()

    Column(modifier = modifier) {
        attributes.forEach { attribute ->
            AttributeGroup(
                attributeWithSkills = attribute,
                onChangeAttribute = { viewModel.updateAttribute(it) },
                onChangeSkill = { viewModel.updateSkill(it) },
                onExpand = { viewModel.onExpand(attribute.attribute.attributeId) },
                expanded = attribute.attribute.attributeId == viewModel.expandedAttributeId.value
            )
        }
    }
}

@Composable
fun AttributeGroup(
    attributeWithSkills: AttributeWithSkillsAndSpecializations,
    onChangeAttribute: (Attribute) -> Unit,
    onChangeSkill: (Skill) -> Unit,
    onExpand: () -> Unit,
    expanded: Boolean
) {
    Column {
        AttributeHeader(
            attribute = attributeWithSkills.attribute,
            onChange = onChangeAttribute,
            onExpand = onExpand,
            expanded = expanded
        )
        if (expanded) {
            SkillList(
                attributeWithSkills.skills,
                onChangeSkill = onChangeSkill
            )
        }
    }
}

@Composable
fun SkillView(
    skill: Skill,
    onChangeSkill: (Skill) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp)
            .clip(CutCornerShape(4.dp, 0.dp, 4.dp, 0.dp))
            .background(Color.DarkGray)
            .padding(4.dp)
    ) {
        Text(text = skill.name, Modifier.weight(1F))
        Button(onClick = { onChangeSkill(skill.copy(level = skill.level - 1)) }) {
            Text(text = "-")
        }
        Text(text = skill.level.toString())
        Button(onClick = { onChangeSkill(skill.copy(level = skill.level + 1)) }) {
            Text(text = "+")
        }
    }
}

@Composable
fun SkillList(
    skillsWithSpecializations: List<SkillWithSpecializations>,
    onChangeSkill: (Skill) -> Unit
) {
    Column(
        Modifier.padding(bottom = 8.dp)
    ) {
        skillsWithSpecializations.forEach {
            SkillView(
                skill = it.skill,
                onChangeSkill = onChangeSkill)
        }
    }
}

@Composable
fun AttributeHeader(
    attribute: Attribute,
    onChange: (Attribute) -> Unit,
    onExpand: () -> Unit,
    expanded: Boolean
) {
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
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
                text = attribute.name,
                Modifier.weight(1F)
            )
            Button(onClick = { onChange(attribute.copy(level = attribute.level - 1)) }) {
                Text(text = "-")
            }
            Text(text = attribute.level.toString())
            Button(onClick = { onChange(attribute.copy(level = attribute.level + 1)) }) {
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