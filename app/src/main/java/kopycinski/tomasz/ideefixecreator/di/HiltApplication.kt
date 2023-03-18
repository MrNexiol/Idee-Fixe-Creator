package kopycinski.tomasz.ideefixecreator.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kopycinski.tomasz.ideefixecreator.repository.AttributeRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class HiltApplication : Application() {

    @Inject lateinit var attributeRepository: AttributeRepository

    override fun onCreate() {
        super.onCreate()
        val sharedPref = this.getSharedPreferences("prefs", MODE_PRIVATE)
        val isFirstOpen = sharedPref.getBoolean(FIRST_OPEN, true)

        if (isFirstOpen) {
            runBlocking {
                attributeRepository.insertAttributes(this@HiltApplication)
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