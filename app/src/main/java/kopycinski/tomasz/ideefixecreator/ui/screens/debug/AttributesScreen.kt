package kopycinski.tomasz.ideefixecreator.ui.screens.debug

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import kopycinski.tomasz.ideefixecreator.viewmodel.DebugViewModel

@Composable
fun AttributesScreen(
    viewModel: DebugViewModel = hiltViewModel()
) {
    val list by viewModel.attr

    LazyColumn {
        items(list) {
            Text(text = it.name, color = Color.White)
            Text(text = it.description, color = Color.White)
        }
    }
}