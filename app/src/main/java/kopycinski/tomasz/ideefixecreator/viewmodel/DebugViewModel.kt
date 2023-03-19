package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.SkillNEW
import kopycinski.tomasz.ideefixecreator.repository.AttributeRepository
import kopycinski.tomasz.ideefixecreator.repository.SkillRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DebugViewModel @Inject constructor(
    private val attributeRepository: AttributeRepository,
    private val skillRepository: SkillRepository
): ViewModel() {
    var attr: MutableState<List<AttributeNEW>> = mutableStateOf(listOf())
    var skill: MutableState<List<SkillNEW>> = mutableStateOf(listOf())
    init {
        viewModelScope.launch {
            attr.value = attributeRepository.getAll()
            skill.value = skillRepository.getAllNew()
        }
    }
}