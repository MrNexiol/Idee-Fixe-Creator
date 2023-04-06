package kopycinski.tomasz.ideefixecreator.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kopycinski.tomasz.ideefixecreator.database.entity.recent.AttributeNEW
import kopycinski.tomasz.ideefixecreator.database.entity.recent.CharacterSheetAttributeCrossRef
import kopycinski.tomasz.ideefixecreator.repository.AttributeRepository
import kopycinski.tomasz.ideefixecreator.repository.CharacterSheetRepository
import kopycinski.tomasz.ideefixecreator.repository.SkillRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class HiltApplication : Application() {

    @Inject lateinit var attributeRepository: AttributeRepository
    @Inject lateinit var skillRepository: SkillRepository
    @Inject lateinit var characterSheetRepository: CharacterSheetRepository

    override fun onCreate() {
        super.onCreate()
        val sharedPref = this.getSharedPreferences("prefs", MODE_PRIVATE)
        val isFirstOpen = sharedPref.getBoolean(FIRST_OPEN, true)

        if (isFirstOpen) {
            runBlocking {
                attributeRepository.insertAttributes(this@HiltApplication)
                skillRepository.insert(this@HiltApplication)

                val charId = characterSheetRepository.insertCharacterSheetNEW()
                for (attr in AttributeNEW.attributeList(this@HiltApplication)) {
                    attributeRepository.insertAttributeCharacterSheetCrossRef(
                        CharacterSheetAttributeCrossRef(charId, attr.attributeID, attr.attributeID.toInt())
                    )
                }
            }
            with(sharedPref.edit()) {
                putBoolean(FIRST_OPEN, false)
                apply()
            }
        }
    }

    companion object {
        private val FIRST_OPEN = "first_open"
    }
}