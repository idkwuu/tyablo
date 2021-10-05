// Night mode using osmdroid. Answer by ecle (https://stackoverflow.com/users/980521/ecle)
// https://stackoverflow.com/a/53988096/13188582
// Adapted to Kotlin and static objects

package dev.idkwuu.tyablo.data.mapfilters

import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter

object DarkestMapFilter {
    private val inverseMatrix = ColorMatrix(
        floatArrayOf(
            -1.0f, 0.0f, 0.0f, 0.0f, 255f,
            0.0f, -1.0f, 0.0f, 0.0f, 255f,
            0.0f, 0.0f, -1.0f, 0.0f, 255f,
            0.0f, 0.0f, 0.0f, 1.0f, 0.0f
        )
    )

    private val destinationColor: Int = Color.parseColor("#FF2A2A2A")
    private val lr: Float = (255.0f - Color.red(destinationColor)) / 255.0f
    private val lg: Float = (255.0f - Color.green(destinationColor)) / 255.0f
    private val lb: Float = (255.0f - Color.blue(destinationColor)) / 255.0f

    private val grayscaleMatrix = ColorMatrix(
        floatArrayOf(
            lr, lg, lb, 0f, 0f,  //
            lr, lg, lb, 0f, 0f,  //
            lr, lg, lb, 0f, 0f, 0f, 0f, 0f, 0f, 255f
        )
    )

    private val dr: Int = Color.red(destinationColor)
    private val dg: Int = Color.green(destinationColor)
    private val db: Int = Color.blue(destinationColor)
    private val drf = dr / 255f
    private val dgf = dg / 255f
    private val dbf = db / 255f

    private val tintMatrix: ColorMatrix = ColorMatrix(
        floatArrayOf(
            drf,
            0f,
            0f,
            0f,
            0f,
            0f,
            dgf,
            0f,
            0f,
            0f,
            0f,
            0f,
            dbf,
            0f,
            0f,
            0f,
            0f,
            0f,
            1f,
            0f
        )
    )

    private val lDestination = drf * lr + dgf * lg + dbf * lb
    private val scale = 1f - lDestination
    private val translate = 1 - scale * 0.5f
    private val scaleMatrix: ColorMatrix = ColorMatrix(
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

    val filter = ColorMatrixColorFilter(scaleMatrix)

    init {
        grayscaleMatrix.preConcat(inverseMatrix)
        tintMatrix.preConcat(grayscaleMatrix)
        scaleMatrix.preConcat(tintMatrix)
    }
}