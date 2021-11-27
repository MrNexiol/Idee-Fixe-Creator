package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.repository.CharacterSheetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCreateViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository
) : ViewModel() {

    init {
        getCharacterSheet(1)
    }

    private val _characterSheet = MutableStateFlow(CharacterSheet())
    val characterSheet: StateFlow<CharacterSheet> = _characterSheet

    private fun getCharacterSheet(id: Long = -1) {
        viewModelScope.launch {
            characterSheetRepository.getOrCreateCharacter(id).collect { characterSheet ->
                _characterSheet.value = characterSheet
            }
        }
    }

    fun insertCharacterSheet(characterSheet: CharacterSheet) {
        viewModelScope.launch {
            characterSheetRepository.insertCharacterSheet(characterSheet)
        }
    }
}