@file:JvmName("GesturesUtils")

package com.mapbox.maps.plugin.gestures

import com.mapbox.android.gestures.AndroidGesturesManager
import com.mapbox.maps.plugin.Plugin
import com.mapbox.maps.plugin.ScrollMode
import com.mapbox.maps.plugin.delegates.MapPluginExtensionsDelegate
import com.mapbox.maps.plugin.delegates.MapPluginProviderDelegate
import com.mapbox.maps.plugin.gestures.generated.GesturesSettings

/**
 * Extension val for MapView to get the Gestures plugin instance.
 */
val MapPluginProviderDelegate.gestures: GesturesPlugin
  @JvmName("getGestures")
  get() = this.getPlugin(Plugin.MAPBOX_GESTURES_PLUGIN_ID)!!

/**
 * Add a callback that is invoked when the map is clicked.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnMapClickListener(onMapClickListener: OnMapClickListener) {
  gesturesPlugin { addOnMapClickListener(onMapClickListener) }
}

/**
 * Remove a callback that is invoked when the map is clicked.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnMapClickListener(onMapClickListener: OnMapClickListener) {
  gesturesPlugin { removeOnMapClickListener(onMapClickListener) }
}

/**
 * Add a callback that is invoked when the map is long clicked.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnMapLongClickListener(onMapLongClickListener: OnMapLongClickListener) {
  gesturesPlugin { addOnMapLongClickListener(onMapLongClickListener) }
}

/**
 * Remove a callback that is invoked when the map is long clicked.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnMapLongClickListener(onMapLongClickListener: OnMapLongClickListener) {
  gesturesPlugin { removeOnMapLongClickListener(onMapLongClickListener) }
}

/**
 * Add a callback that is invoked when the map is has received a fling gesture.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnFlingListener(onFlingListener: OnFlingListener) {
  gesturesPlugin { addOnFlingListener(onFlingListener) }
}

/**
 * Remove a callback that is invoked when the map is has received a fling gesture.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnFlingListener(onFlingListener: OnFlingListener) {
  gesturesPlugin { removeOnFlingListener(onFlingListener) }
}

/**
 * Add a callback that is invoked when the map is moved.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnMoveListener(listener: OnMoveListener) {
  gesturesPlugin { addOnMoveListener(listener) }
}

/**
 * Remove a callback that is invoked when the map is moved.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnMoveListener(listener: OnMoveListener) {
  gesturesPlugin { removeOnMoveListener(listener) }
}

/**
 * Add a callback that is invoked when the map is rotated.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnRotateListener(listener: OnRotateListener) {
  gesturesPlugin { addOnRotateListener(listener) }
}

/**
 * Remove a callback that is invoked when the map is rotated.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnRotateListener(listener: OnRotateListener) {
  gesturesPlugin { removeOnRotateListener(listener) }
}

/**
 * Add a callback that is invoked when the map is scaled.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnScaleListener(listener: OnScaleListener) {
  gesturesPlugin { addOnScaleListener(listener) }
}

/**
 * Remove a callback that is invoked when the map is scaled.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnScaleListener(listener: OnScaleListener) {
  gesturesPlugin { removeOnScaleListener(listener) }
}

/**
 * Add a callback that is invoked when the map is shoved.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.addOnShoveListener(listener: OnShoveListener) {
  gesturesPlugin { addOnShoveListener(listener) }
}

/**
 * Remove a callback that is invoked when the map is shoved.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.removeOnShoveListener(listener: OnShoveListener) {
  gesturesPlugin { removeOnShoveListener(listener) }
}

/**
 * Get the current configured AndroidGesturesManager.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.getGesturesManager(): AndroidGesturesManager? {
  return gesturesPlugin { getGesturesManager() } as AndroidGesturesManager?
}

/**
 * Set the AndroidGesturesManager instance.
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
fun MapPluginExtensionsDelegate.setGesturesManager(
  androidGesturesManager: AndroidGesturesManager,
  attachDefaultListeners: Boolean,
  setDefaultMutuallyExclusives: Boolean
) {
  gesturesPlugin {
    setGesturesManager(
      androidGesturesManager,
      attachDefaultListeners,
      setDefaultMutuallyExclusives
    )
  }
}

/**
 * Get copy of current gesture settings.
 *
 * Updating any property of [GesturesSettings] object returned will not take any effect,
 * please use MapView.gestures.updateSettings { } instead.
 *
 * Gesture plugin with id = [Plugin.MAPBOX_GESTURES_PLUGIN_ID] must be added while constructing
 * [com.mapbox.maps.MapView] as part of [com.mapbox.maps.MapInitOptions.plugins].
 *
 * @throws IllegalStateException if gestures plugin was not added.
 * @see [com.mapbox.maps.MapInitOptions]
 */
@Deprecated(
  "Gesture plugin instance obtained from MapView should be used instead to get a copy of current settings object. " +
    "In order to set particular setting same gesture plugin instance should be used e.g. mapView.gestures.rotateEnabled = false",
  replaceWith = ReplaceWith(
    "mapView.gestures.getSettings()",
  ),
)
fun MapPluginExtensionsDelegate.getGesturesSettings() =
  gesturesPlugin { getSettings() } as GesturesSettings?

/**
 * Returns if the scroll is horizontally limited,
 * In other words, the scroll mode is set to vertical.
 */
fun GesturesSettings.isScrollHorizontallyLimited(): Boolean {
  return scrollMode == ScrollMode.VERTICAL
}

/**
 * Returns if the scroll is vertically limited,
 * In other words, the scroll mode is set to horizontal.
 */
fun GesturesSettings.isScrollVerticallyLimited(): Boolean {
  return scrollMode == ScrollMode.HORIZONTAL
}