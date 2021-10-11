package dev.idkwuu.tyablo.ui

import android.preference.PreferenceManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import dev.idkwuu.tyablo.data.mapfilters.MapFilters
import dev.idkwuu.tyablo.state.GlobalData
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay


@Composable
fun Map() {
    val isAppActive by GlobalData.isAppActive.observeAsState(true)

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context).apply {
                Configuration.getInstance().load(context, PreferenceManager.getDefaultSharedPreferences(context))
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                val rotationGestureOverlay = RotationGestureOverlay(this).apply {
                    isEnabled = true
                    overlays.add(this)
                }
                zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
                controller.setZoom(9.5)
                controller.setCenter(GeoPoint(48.8583, 2.2944))
                //overlayManager.tilesOverlay.setColorFilter(MapFilters.dark())
            }
        },
        update = { mapView ->
            if (isAppActive) {
                mapView.onResume()
            } else {
                mapView.onPause()
            }
        }
    )
}