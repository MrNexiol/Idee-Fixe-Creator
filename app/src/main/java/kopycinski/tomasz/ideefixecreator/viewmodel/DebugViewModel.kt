package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeWithLevel
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeWithSkillsNEW
import kopycinski.tomasz.ideefixecreator.repository.AttributeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DebugViewModel @Inject constructor(
    private val attributeRepository: AttributeRepository
): ViewModel() {
    var attrWithSkills: MutableState<List<AttributeWithSkillsNEW>> = mutableStateOf(listOf())
    var attrWithLevels: MutableState<List<AttributeWithLevel>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            attrWithSkills.value = attributeRepository.getAllWithSkills()
            attrWithLevels.value = attributeRepository.getAllByCharId(1)
        }
    }
}