package kopycinski.tomasz.ideefixecreator.viewmodel

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

    private var didLoad = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    private val _attributes = MutableStateFlow(listOf<Attribute>())
    val characterSheet = _characterSheet.asStateFlow()
    val attributes = _attributes.asStateFlow()

    fun getCharacterSheet() {
        if (!didLoad) {
            viewModelScope.launch {
                characterSheetRepository.createCharacter().collect { characterSheetWithAttributes ->
                    didLoad = true
                    _characterSheet.value = characterSheetWithAttributes.characterSheet
                    _attributes.value = characterSheetWithAttributes.attributes
                }
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
}