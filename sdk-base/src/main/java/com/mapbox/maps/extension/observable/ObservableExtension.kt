package com.mapbox.maps.extension.observable

import com.google.gson.Gson
import com.mapbox.maps.Event
import com.mapbox.maps.MapEvents
import com.mapbox.maps.ObservableInterface
import com.mapbox.maps.Observer
import com.mapbox.maps.extension.observable.eventdata.*
import com.mapbox.maps.extension.observable.eventdata.ResourceEventData

private val gson by lazy {
  Gson()
}

/**
 * Subscribes an Observer for of event type "resource-request".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeResourceRequest(observer: Observer) =
  subscribe(observer, listOf(MapEvents.RESOURCE_REQUEST))

/**
 * Unsubscribe an Observer for event types "resource-request".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeResourceRequest(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.RESOURCE_REQUEST))

// Camera events
/**
 * Subscribes an Observer for of event type "camera-changed".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeCameraChange(observer: Observer) =
  subscribe(observer, listOf(MapEvents.CAMERA_CHANGED))

/**
 * Unsubscribe an Observer for event types "camera-changed".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeCameraChange(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.CAMERA_CHANGED))

// Map events
/**
 * Subscribes an Observer for of event type "map-idle".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeMapIdle(observer: Observer) =
  subscribe(observer, listOf(MapEvents.MAP_IDLE))

/**
 * Unsubscribe an Observer for event types "map-idle".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeMapIdle(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.MAP_IDLE))

/**
 * Subscribes an Observer for of event type "map-loading-error".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeMapLoadingError(observer: Observer) =
  subscribe(observer, listOf(MapEvents.MAP_LOADING_ERROR))

/**
 * Unsubscribe an Observer for event types "map-loading-error".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeMapLoadingError(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.MAP_LOADING_ERROR))

/**
 * Subscribes an Observer for of event type "map-loaded".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeMapLoaded(observer: Observer) =
  subscribe(observer, listOf(MapEvents.MAP_LOADED))

/**
 * Unsubscribe an Observer for event types "map-loaded".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeMapLoaded(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.MAP_LOADED))

// Style events
/**
 * Subscribes an Observer for of event type "style-data-loaded".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeStyleDataLoaded(observer: Observer) =
  subscribe(observer, listOf(MapEvents.STYLE_DATA_LOADED))

/**
 * Unsubscribe an Observer for event types "style-data-loaded".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeStyleDataFinished(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.STYLE_DATA_LOADED))

/**
 * Subscribes an Observer for of event type "style-loaded".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeStyleLoaded(observer: Observer) =
  subscribe(observer, listOf(MapEvents.STYLE_LOADED))

/**
 * Unsubscribe an Observer for event types "style-loaded".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeStyleLoaded(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.STYLE_LOADED))

/**
 * Subscribes an Observer for of event type "style-image-missing".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeStyleImageMissing(observer: Observer) =
  subscribe(observer, listOf(MapEvents.STYLE_IMAGE_MISSING))

/**
 * Unsubscribe an Observer for event types "style-image-missing".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeStyleImageMissing(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.STYLE_IMAGE_MISSING))

/**
 * Subscribes an Observer for of event type "style-image-remove-unused".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeStyleImageUnused(observer: Observer) =
  subscribe(observer, listOf(MapEvents.STYLE_IMAGE_REMOVE_UNUSED))

/**
 * Unsubscribe an Observer for event types "style-image-remove-unused".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeStyleImageUnused(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.STYLE_IMAGE_REMOVE_UNUSED))

// Render frame events
/**
 * Subscribes an Observer for of event type "render-frame-started".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeRenderFrameStarted(observer: Observer) =
  subscribe(observer, listOf(MapEvents.RENDER_FRAME_STARTED))

/**
 * Unsubscribe an Observer for event types "render-frame-started".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeRenderFrameStarted(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.RENDER_FRAME_STARTED))

/**
 * Subscribes an Observer for of event type "render-frame-finished".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeRenderFrameFinished(observer: Observer) =
  subscribe(observer, listOf(MapEvents.RENDER_FRAME_FINISHED))

/**
 * Unsubscribe an Observer for event types "render-frame-finished".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeRenderFrameFinished(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.RENDER_FRAME_FINISHED))

/**
 * Subscribes an Observer for of event type "source-added".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeSourceAdded(observer: Observer) =
  subscribe(observer, listOf(MapEvents.SOURCE_ADDED))

/**
 * Unsubscribe an Observer for event types "source-added".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeSourceAdded(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.SOURCE_ADDED))

/**
 * Subscribes an Observer for of event type "source-data-loaded".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeSourceDataLoaded(observer: Observer) =
  subscribe(observer, listOf(MapEvents.SOURCE_DATA_LOADED))

/**
 * Unsubscribe an Observer for event types "source-data-loaded".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeSourceDataLoaded(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.SOURCE_DATA_LOADED))

/**
 * Subscribes an Observer for of event type "source-removed".
 *
 * Observable will hold a strong reference to an Observer instance, therefore,
 * in order to stop receiving notifications, caller must call unsubscribe with an
 * Observer instance used for an initial subscription.
 *
 * @param observer an Observer
 */
fun ObservableInterface.subscribeSourceRemoved(observer: Observer) =
  subscribe(observer, listOf(MapEvents.SOURCE_REMOVED))

/**
 * Unsubscribe an Observer for event types "source-removed".
 *
 * @param observer an Observer
 */
fun ObservableInterface.unsubscribeSourceRemoved(observer: Observer) =
  unsubscribe(observer, listOf(MapEvents.SOURCE_REMOVED))

// Parser extension functions for event data.
/**
 * Get the parsed event data for resource-request event.
 * @return a parsed ResourceEventData object.
 */
fun Event.getResourceEventData(): ResourceEventData {
  val json = data.toJson()
  return gson.fromJson(json, ResourceEventData::class.java)
}

/**
 * Get the parsed event data for map loaded event.
 * @return a parsed MapLoadedEventData object.
 */
fun Event.getMapLoadedEventData(): MapLoadedEventData {
  val json = data.toJson()
  return gson.fromJson(json, MapLoadedEventData::class.java)
}

/**
 * Get the parsed event data for map loading error event.
 * @return a parsed MapLoadingErrorEventData object.
 */
fun Event.getMapLoadingErrorEventData(): MapLoadingErrorEventData {
  val json = data.toJson()
  return gson.fromJson(json, MapLoadingErrorEventData::class.java)
}

/**
 * Get the parsed event data for map idle event.
 * @return a parsed MapIdleEventData object.
 */
fun Event.getMapIdleEventData(): MapIdleEventData {
  val json = data.toJson()
  return gson.fromJson(json, MapIdleEventData::class.java)
}

/**
 * Get the parsed event data for style data loaded event.
 * @return a parsed StyleDataLoadedEventData object.
 */
fun Event.getStyleDataLoadedEventData(): StyleDataLoadedEventData {
  val json = data.toJson()
  return gson.fromJson(json, StyleDataLoadedEventData::class.java)
}

/**
 * Get the parsed event data for style loaded event.
 * @return a parsed StyleLoadedEventData object.
 */
fun Event.getStyleLoadedEventData(): StyleLoadedEventData {
  val json = data.toJson()
  return gson.fromJson(json, StyleLoadedEventData::class.java)
}

/**
 * Get the parsed event data for source data loaded event.
 * @return a parsed SourceDataLoadedEventData object.
 */
fun Event.getSourceDataLoadedEventData(): SourceDataLoadedEventData {
  val json = data.toJson()
  return gson.fromJson(json, SourceDataLoadedEventData::class.java)
}

/**
 * Get the parsed event data for style missing event.
 * @return a parsed StyleImageMissingEventData.
 */
fun Event.getStyleImageMissingEventData(): StyleImageMissingEventData {
  val json = data.toJson()
  return gson.fromJson(json, StyleImageMissingEventData::class.java)
}

/**
 * Get the parsed event data for style image unused event.
 * @return a parsed StyleImageUnusedEventData.
 */
fun Event.getStyleImageUnusedEventData(): StyleImageUnusedEventData {
  val json = data.toJson()
  return gson.fromJson(json, StyleImageUnusedEventData::class.java)
}

/**
 * Get the parsed event data for source added event.
 * @return a parsed IDStringEventData.
 */
fun Event.getSourceAddedEventData(): SourceAddedEventData {
  val json = data.toJson()
  return gson.fromJson(json, SourceAddedEventData::class.java)
}

/**
 * Get the parsed event data for source removed event.
 * @return a parsed SourceRemovedEventData.
 */
fun Event.getSourceRemovedEventData(): SourceRemovedEventData {
  val json = data.toJson()
  return gson.fromJson(json, SourceRemovedEventData::class.java)
}

/**
 * Get the parsed event data for render frame started event.
 * @return a parsed RenderFrameStartedEventData.
 */
fun Event.getRenderFrameStartedEventData(): RenderFrameStartedEventData {
  val json = data.toJson()
  return gson.fromJson(json, RenderFrameStartedEventData::class.java)
}

/**
 * Get the parsed event data for render frame finished event.
 * @return a parsed RenderFrameFinishedEventData.
 */
fun Event.getRenderFrameFinishedEventData(): RenderFrameFinishedEventData {
  val json = data.toJson()
  return gson.fromJson(json, RenderFrameFinishedEventData::class.java)
}

/**
 * Get the parsed event data for camera changed event.
 * @return a parsed CameraChangedEventData.
 */
fun Event.getCameraChangedEventData(): CameraChangedEventData {
  val json = data.toJson()
  return gson.fromJson(json, CameraChangedEventData::class.java)
}