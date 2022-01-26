package kopycinski.tomasz.ideefixecreator.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DefaultColorsPalette = lightColors(
    primary = primary,
    onPrimary = black,
    primaryVariant = primaryVariant,
    secondary = secondary,
    background = background
)

@Composable
fun IdeeFixeCreatorTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = DefaultColorsPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}