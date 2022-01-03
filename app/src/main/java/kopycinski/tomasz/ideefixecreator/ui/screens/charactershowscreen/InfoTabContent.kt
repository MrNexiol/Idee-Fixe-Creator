package kopycinski.tomasz.ideefixecreator.ui.screens.charactershowscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kopycinski.tomasz.ideefixecreator.viewmodel.CharacterShowViewModel

@Composable
fun InfoTabContent(
    modifier: Modifier = Modifier,
    viewModel: CharacterShowViewModel
) {
    val characterSheet by viewModel.characterSheet.collectAsState()

    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, MaterialTheme.shapes.large)
                .padding(8.dp)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(100.dp)
                        .padding(end = 8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Gray)
                )
                Column {
                    Text("Nazwisko: ${characterSheet.surname}")
                    Text("Imiona: ${characterSheet.names}")
                    Text("Obywatelstwo: ${characterSheet.nationality}")
                    Text("Płeć: ${characterSheet.gender}")
                    Text("Wiek: ${characterSheet.age}")
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize()
                .border(1.dp, Color.LightGray, MaterialTheme.shapes.large)
                .padding(8.dp)
        ) {
            Text("Notatki")
            Text(characterSheet.notes)
        }
    }
}