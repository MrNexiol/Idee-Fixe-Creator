package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.*
import kopycinski.tomasz.ideefixecreator.database.repository.AdvantageRepository
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
    private val skillRepository: SkillRepository,
    private val advantageRepository: AdvantageRepository
) : ViewModel() {

    private var didLoadCharacter = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    private val _experience = MutableStateFlow(0)
    private val _attributes = MutableStateFlow(listOf<AttributeWithSkillsAndSpecializations>())
    private val _advantages = MutableStateFlow(listOf<Advantage>())
    private val _addedAdvantageIds = MutableStateFlow(listOf<CharacterSheetAdvantageCrossRef>())

    val expandedAttributeId = mutableStateOf(-1L)
    val characterSheet = _characterSheet.asStateFlow()
    val experience = _experience.asStateFlow()
    val attributes = _attributes.asStateFlow()
    val advantages = _advantages.asStateFlow()
    val addedAdvantages = _addedAdvantageIds.asStateFlow()

    fun loadData(characterSheetId: Long? = null) {
        viewModelScope.launch {
            getCharacter(characterSheetId)
        }
        viewModelScope.launch {
            getAdvantages()
        }
    }

    private suspend fun getAddedAdvantageIds(characterSheetId: Long) {
        characterSheet.collect {
            advantageRepository.getAdvantageIdsByCharacterId(characterSheetId).collect { ids ->
                _addedAdvantageIds.value = ids
            }
        }
    }

    private suspend fun getAdvantages() {
        advantageRepository.getAdvantages().collect { advantages ->
            _advantages.value = advantages
        }
    }

    private suspend fun getCharacter(id: Long? = null) {
        if (!didLoadCharacter) {
            characterSheetRepository.createOrLoadCharacter(id).collect { characterSheetWithStats ->
                didLoadCharacter = true
                _characterSheet.value = characterSheetWithStats.characterSheet
                _experience.value = characterSheetWithStats.characterSheet.experience
                _attributes.value = characterSheetWithStats.attributes
                viewModelScope.launch {
                    getAddedAdvantageIds(characterSheetWithStats.characterSheet.characterSheetId)
                }
            }
        }
    }

    fun updateCharacterSheet(characterSheet: CharacterSheet) {
        viewModelScope.launch {
            characterSheetRepository.updateCharacterSheet(characterSheet)
        }
    }

    fun onExpand(attributeId: Long) {
        expandedAttributeId.value = if (expandedAttributeId.value == attributeId) {
            -1
        } else {
            attributeId
        }
    }

    private fun decreaseExperience(value: Int) {
        viewModelScope.launch {
            characterSheetRepository.updateCharacterSheet(
                characterSheet.value.copy(experience = characterSheet.value.experience - value)
            )
        }
    }

    private fun increaseExperience(value: Int) {
        viewModelScope.launch {
            characterSheetRepository.updateCharacterSheet(
                characterSheet.value.copy(experience = characterSheet.value.experience + value)
            )
        }
    }

    fun decreaseAttribute(attribute: Attribute) {
        val attr = attribute.copy(level = --attribute.level)
        viewModelScope.launch {
            attributeRepository.updateAttribute(attr)
        }
        increaseExperience(Attribute.UPGRADE_COSTS_FOR_LEVELS[attr.level]!!)
    }

    fun increaseAttribute(attribute: Attribute) {
        val attr = attribute.copy()
        decreaseExperience(Attribute.UPGRADE_COSTS_FOR_LEVELS[attr.level]!!)
        viewModelScope.launch {
            attr.level++
            attributeRepository.updateAttribute(attr)
        }
    }

    fun decreaseSkill(skill: Skill) {
        val newSkill = skill.copy(level = --skill.level)
        if (newSkill.upgradeCost > 1) newSkill.upgradeCost--
        viewModelScope.launch {
            skillRepository.updateSkill(newSkill)
        }
        increaseExperience(newSkill.upgradeCost)
    }

    fun increaseSkill(skill: Skill, parentAttributeLevel: Int) {
        val newSkill = skill.copy()
        newSkill.level++
        decreaseExperience(newSkill.upgradeCost)
        if (parentAttributeLevel <= newSkill.level) newSkill.upgradeCost++
        viewModelScope.launch {
            skillRepository.updateSkill(newSkill)
        }
    }

    fun modifyAdvantage(advantageId: Long, newCost: Int, newLevel: Int, existingAdv: CharacterSheetAdvantageCrossRef?) {
        if (existingAdv != null) {
            when {
                existingAdv.level > newLevel -> {
                    updateAdvCrossRef(existingAdv.copy(level = newLevel, cost = newCost))
                    increaseExperience(existingAdv.cost - newCost)
                }
                existingAdv.level < newLevel -> {
                    updateAdvCrossRef(existingAdv.copy(level = newLevel, cost = newCost))
                    decreaseExperience(newCost - existingAdv.cost)
                }
                else -> {
                    removeAdvantage(advantageId)
                    increaseExperience(newCost)
                }
            }
        } else {
            insertAdvantage(advantageId, newLevel, newCost)
            decreaseExperience(newCost)
        }
    }

    private fun updateAdvCrossRef(crossRef: CharacterSheetAdvantageCrossRef) {
        viewModelScope.launch {
            advantageRepository.updateAdvCharCrossRef(crossRef)
        }
    }

    private fun removeAdvantage(advantageId: Long) {
        viewModelScope.launch {
            advantageRepository.removeAdvCharCrossRef(characterSheet.value.characterSheetId, advantageId)
        }
    }

    private fun insertAdvantage(advantageId: Long, level: Int, cost: Int) {
        viewModelScope.launch {
            advantageRepository.insertAdvCharCrossRef(characterSheet.value.characterSheetId, advantageId, level, cost)
        }
    }
}