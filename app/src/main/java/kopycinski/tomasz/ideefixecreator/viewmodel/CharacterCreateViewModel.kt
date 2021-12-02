package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.Attribute
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.repository.AttributeRepository
import kopycinski.tomasz.ideefixecreator.database.repository.CharacterSheetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCreateViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository,
    private val attributeRepository: AttributeRepository
) : ViewModel() {

    private var didLoadCharacter = false
    private var didLoadAttributes = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    private val _attributes = MutableStateFlow(listOf<Attribute>())

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
            characterSheetRepository.createCharacter().collect {
                didLoadCharacter = true
                _characterSheet.value = it
                getAttributes(it.characterSheetId)
            }
        }
    }

    private suspend fun getAttributes(characterSheetId: Long) {
        if (!didLoadAttributes) {
            attributeRepository.createAttributes(characterSheetId).collect {
                didLoadAttributes = true
                _attributes.value = it
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
}