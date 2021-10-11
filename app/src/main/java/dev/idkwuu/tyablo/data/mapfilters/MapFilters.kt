package dev.idkwuu.tyablo.data.mapfilters

import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import org.osmdroid.views.overlay.TilesOverlay


object MapFilters {
    val darkest = DarkestMapFilter.filter
    val invertedColors = TilesOverlay.INVERT_COLORS

    fun dark(): ColorMatrixColorFilter {
        //taking cue from https://medium.com/square-corner-blog/welcome-to-the-color-matrix-64d112e3f43d
        //taking cue from https://medium.com/square-corner-blog/welcome-to-the-color-matrix-64d112e3f43d
        val inverseMatrix = ColorMatrix(
            floatArrayOf(
                -1.0f, 0.0f, 0.0f, 0.0f, 255f,
                0.0f, -1.0f, 0.0f, 0.0f, 255f,
                0.0f, 0.0f, -1.0f, 0.0f, 255f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )

        val destinationColor: Int = Color.parseColor("#FF2A2A2A")
        val lr: Float = (255.0f - Color.red(destinationColor)) / 255.0f
        val lg: Float = (255.0f - Color.green(destinationColor)) / 255.0f
        val lb: Float = (255.0f - Color.blue(destinationColor)) / 255.0f
        val grayscaleMatrix = ColorMatrix(
            floatArrayOf(
                lr, lg, lb, 0f, 0f,  //
                lr, lg, lb, 0f, 0f,  //
                lr, lg, lb, 0f, 0f, 0f, 0f, 0f, 0f, 255f
            )
        )
        grayscaleMatrix.preConcat(inverseMatrix)
        val dr: Int = Color.red(destinationColor)
        val dg: Int = Color.green(destinationColor)
        val db: Int = Color.blue(destinationColor)
        val drf = dr / 255f
        val dgf = dg / 255f
        val dbf = db / 255f
        val tintMatrix = ColorMatrix(
            floatArrayOf(
                drf, 0f, 0f, 0f, 0f, 0f, dgf, 0f, 0f, 0f, 0f, 0f, dbf, 0f, 0f, 0f, 0f, 0f, 1f, 0f
            )
        )
        tintMatrix.preConcat(grayscaleMatrix)
        val lDestination = drf * lr + dgf * lg + dbf * lb
        val scale = 1f - lDestination
        val translate = 1 - scale * 0.5f
        val scaleMatrix = ColorMatrix(
            floatArrayOf(
                scale,
                0f,
                0f,
                0f,
                dr * translate,
                0f,
                scale,
                0f,
                0f,
                dg * translate,
                0f,
                0f,
                scale,
                0f,
                db * translate,
                0f,
                0f,
                0f,
                1f,
                0f
            )
        )
        scaleMatrix.preConcat(tintMatrix)
        return ColorMatrixColorFilter(scaleMatrix)
    }
}