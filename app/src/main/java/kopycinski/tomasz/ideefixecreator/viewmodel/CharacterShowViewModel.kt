package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.database.entity.AttributeWithSkillsAndSpecializations
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.repository.CharacterSheetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterShowViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository
) : ViewModel() {
    private var didLoadCharacter = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    private val _attributes = MutableStateFlow(listOf<AttributeWithSkillsAndSpecializations>())
    private val _advantages = MutableStateFlow(listOf<Advantage>())

    val characterSheet = _characterSheet.asStateFlow()
    val attributes = _attributes.asStateFlow()
    val advantages = _advantages.asStateFlow()

    fun loadData(characterId: Long) {
        viewModelScope.launch {
            getCharacter(characterId)
        }
    }

    private suspend fun getCharacter(characterId: Long) {
        if (!didLoadCharacter) {
            characterSheetRepository.getCharacterSheetWithStats(characterId).collect { characterSheetWithStats ->
                didLoadCharacter = true
                _characterSheet.value = characterSheetWithStats.characterSheet
                _attributes.value = characterSheetWithStats.attributes
                _advantages.value = characterSheetWithStats.advantages
            }
        }
    }
}