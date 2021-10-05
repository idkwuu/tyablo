package dev.idkwuu.tyablo.data.mapfilters

import org.osmdroid.views.overlay.TilesOverlay

object MapFilters {
    val darkest = DarkestMapFilter.filter
    val invertedColors = TilesOverlay.INVERT_COLORS
}