package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.*
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
    private val _advantages = MutableStateFlow(listOf<Advantage>())
    private val _attributes = MutableStateFlow(listOf<Attribute>())
    private val _skills = MutableStateFlow(listOf<Skill>())

    val characterSheet = _characterSheet.asStateFlow()
    val advantages = _advantages.asStateFlow()
    val attributes = _attributes.asStateFlow()
    val skills = _skills.asStateFlow()

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
                _advantages.value = characterSheetWithStats.advantages
                _attributes.value = characterSheetWithStats.attributes.map { it.attribute }
                _skills.value = characterSheetWithStats.attributes.map { it.skills.map { skill -> skill.skill } }.flatten().sortedBy { it.name }
            }
        }
    }
}