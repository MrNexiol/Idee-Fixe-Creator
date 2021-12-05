package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.AttributeWithSkillsAndSpecializations
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.entity.Skill
import kopycinski.tomasz.ideefixecreator.database.repository.AttributeRepository
import kopycinski.tomasz.ideefixecreator.database.repository.CharacterSheetRepository
import kopycinski.tomasz.ideefixecreator.database.repository.SkillRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCreateViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository,
    private val attributeRepository: AttributeRepository,
    private val skillRepository: SkillRepository
) : ViewModel() {

    private var didLoadCharacter = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    private val _attributes = MutableStateFlow(listOf<AttributeWithSkillsAndSpecializations>())

    val expandedAttributeId = mutableStateOf(-1L)
    val characterSheet = _characterSheet.asStateFlow()
    val attributes = _attributes.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            getCharacter()
        }
    }

    private suspend fun getCharacter() {
        if (!didLoadCharacter) {
            characterSheetRepository.createCharacter().collect { characterSheetWithStats ->
                didLoadCharacter = true
                _characterSheet.value = characterSheetWithStats.characterSheet
                _attributes.value = characterSheetWithStats.attributes
            }
        }
    }

    fun updateCharacterSheet(characterSheet: CharacterSheet) {
        viewModelScope.launch {
            characterSheetRepository.updateCharacterSheet(characterSheet)
        }
    }

    fun updateAttribute(attribute: Attribute) {
        viewModelScope.launch {
            attributeRepository.updateAttribute(attribute)
        }
    }

    fun onExpand(attributeId: Long) {
        expandedAttributeId.value = if (expandedAttributeId.value == attributeId) {
            -1
        } else {
            attributeId
        }
    }

    private suspend fun decreaseExperience(value: Int) {
        characterSheetRepository.updateCharacterSheet(
            characterSheet.value.copy(experience = characterSheet.value.experience - value)
        )
    }

    private suspend fun increaseExperience(value: Int) {
        characterSheetRepository.updateCharacterSheet(
            characterSheet.value.copy(experience = characterSheet.value.experience + value)
        )
    }

    fun decreaseSkill(skill: Skill) {
        val newSkill = skill.copy()
        newSkill.level--
        if (newSkill.upgradeCost > 1) {
            newSkill.upgradeCost--
        }
        viewModelScope.launch {
            skillRepository.updateSkill(newSkill)
            increaseExperience(newSkill.upgradeCost)
        }
    }

    fun increaseSkill(skill: Skill, parentAttributeLevel: Int) {
        val newSkill = skill.copy()
        newSkill.level++
        viewModelScope.launch {
            decreaseExperience(newSkill.upgradeCost)
        }
        if (parentAttributeLevel <= newSkill.level) {
            newSkill.upgradeCost++
        }
        viewModelScope.launch {
            skillRepository.updateSkill(newSkill)
        }
    }
}