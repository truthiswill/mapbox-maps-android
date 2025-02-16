package com.mapbox.maps.testapp.examples.customlayer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.common.Logger
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.LayerPosition
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.testapp.R
import com.mapbox.maps.testapp.databinding.ActivityCustomLayerBinding

/**
 * Test activity showcasing the Custom Layer API
 */
class NativeCustomLayerActivity : AppCompatActivity() {
  private lateinit var mapboxMap: MapboxMap
  private val nativeCustomLayer = NativeExampleCustomLayer()
  private lateinit var binding: ActivityCustomLayerBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityCustomLayerBinding.inflate(layoutInflater)
    setContentView(binding.root)
    mapboxMap = binding.mapView.getMapboxMap()
    mapboxMap.loadStyleUri(
      Style.MAPBOX_STREETS
    ) {
      mapboxMap.setCamera(
        CameraOptions.Builder().center(Point.fromLngLat(116.39053, 39.91448)).zoom(10.0)
          .build()
      )
      initFab()
    }
  }

  private fun initFab() {
    binding.fab.setOnClickListener {
      swapCustomLayer()
    }
  }

  private fun swapCustomLayer() {
    mapboxMap.getStyle()?.let { style ->
      if (style.styleLayerExists(CUSTOM_LAYER_ID)) {
        style.removeStyleLayer(CUSTOM_LAYER_ID)
        binding.fab.setImageResource(R.drawable.ic_layers)
      } else {
        val expected = style.addStyleCustomLayer(
          layerId = CUSTOM_LAYER_ID,
          nativeCustomLayer,
          LayerPosition(null, "building", null)
        )
        expected.error?.let {
          Logger.e(TAG, "Add custom layer exception $it")
        }
        binding.fab.setImageResource(R.drawable.ic_layers_clear)
      }
    }
  }

  private fun updateLayer() {
    mapboxMap.triggerRepaint()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_custom_layer, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_update_layer -> {
        updateLayer()
        true
      }
      R.id.action_set_color_red -> {
        nativeCustomLayer.setColor(1.0f, 0.0f, 0.0f, 1.0f)
        true
      }
      R.id.action_set_color_green -> {
        nativeCustomLayer.setColor(0.0f, 1.0f, 0.0f, 1.0f)
        true
      }
      R.id.action_set_color_blue -> {
        nativeCustomLayer.setColor(0.0f, 0.0f, 1.0f, 1.0f)
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  companion object {
    private const val CUSTOM_LAYER_ID = "custom"
    private const val TAG = "NativeCustomLayerActivity"
  }
}