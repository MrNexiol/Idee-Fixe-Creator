package kopycinski.tomasz.ideefixecreator.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.tan

val Shapes = Shapes(
    small = CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp),
    medium = CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp),
    large = CutCornerShape(8.dp, 0.dp, 8.dp, 0.dp)
)

class ParallelogramShape(private val angle: Float): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ) = Outline.Generic(
        Path().apply {
            val width = size.width - size.height / tan(angle)
            moveTo(size.width - width, 0f)
            lineTo(size.width, 0f)
            lineTo(width, size.height)
            lineTo(0f, size.height)
            lineTo(size.width - width, 0f)
        }
    )
}

val Shapes.parallelogram: Shape
    get() = ParallelogramShape(45f)