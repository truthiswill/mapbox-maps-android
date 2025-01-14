# Changelog for Mapbox Maps SDK v10 for Android

Mapbox welcomes participation and contributions from everyone.

# 10.2.0-rc.1 December 2, 2021

## Bug fixes 🐞
* Fix `replaceWith` template to replace deprecated `queryRenderFeatures` overloaded methods. ([#878](https://github.com/mapbox/mapbox-maps-android/pull/878))
* Do not allow to use one `associatedFeatureId` with multiple view annotations. ([#896](https://github.com/mapbox/mapbox-maps-android/pull/896))
* Fix an issue where shove gesture was not detected when angle between touch points are not horizontal. ([#875](https://github.com/mapbox/mapbox-maps-android/pull/875))
* Fix gestures at high camera pitch near horizon line. ([#927](https://github.com/mapbox/mapbox-maps-android/pull/927), [#925](https://github.com/mapbox/mapbox-maps-android/pull/925))
* Fix fading tiles layout visibility issue on globe view projection zooming in/out. ([#925](https://github.com/mapbox/mapbox-maps-android/pull/925))
* Allow simultaneous zoom and rotate gesture by default and add `GesturesSettings#simultaneousRotateAndPinchToZoomEnabled` config option. ([#885](https://github.com/mapbox/mapbox-maps-android/pull/885))

## Dependencies
* Bump gl-native to v10.2.0-rc.1, common to v21.0.0-rc.2. ([#925](https://github.com/mapbox/mapbox-maps-android/pull/925))

# 10.1.1 December 1, 2021

**NOTE:** As of December 3, 2021, this release is no longer available due to a new bug that was introduced while fixing the billing issue. A new patch will be issued shortly.

## Bug fixes 🐞
* Fix billing issue when upgrading Mapbox Maps SDK from v9 to v10.

## Dependencies
* Bump gl-native to 10.1.1, common to 20.1.1.

# 10.0.1 November 26, 2021

**NOTE:** As of December 3, 2021, this release is no longer available due to a new bug that was introduced while fixing the billing issue. A new patch will be issued shortly.

## Bug fixes 🐞
* Fix billing issue when upgrading Mapbox Maps SDK from v9 to v10.

## Dependencies
* Bump common to v20.0.2.

# 10.2.0-beta.1 November 18, 2021

## Features ✨ and improvements 🏁
* Introduce view annotation support which allows adding Android views on top of the `MapView` anchored to geo-point. ([#834](https://github.com/mapbox/mapbox-maps-android/pull/834))
* Remove `MapView` argument when constructing `AnnotationManager`. Constructor taking `MapView` as parameter is marked as deprecated. ([#766](https://github.com/mapbox/mapbox-maps-android/pull/766))
* Implement cluster API on top of `MapboxMap.queryFeatureExtensions` making it easier to use and providing better alignment with Mapbox Maps v9. ([#773](https://github.com/mapbox/mapbox-maps-android/pull/773))
* Add heatmap and circle layer support to globe view. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Add cancelable Query Rendered Features API to `MapboxMap`. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Improve `MapboxMap.queryRenderedFeatures` performance especially when querying large number of features. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Cache layer layout key inside layer, so that it is not re-evaluated at every parse of the every tile improving rendering performance. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Core renderer prints its version on initialization. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Introduce experimental `MapboxMap.setMemoryBudget` method for setting memory budget for the map and runtime "resource-budget" property for data sources. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Improve performance by avoiding re-layout of invisible fading tiles. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Add utility methods to `CoordinateBounds`. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))

## Bug fixes 🐞
* Fix `MapView.onLowMemory` not being called on low resources. ([#780](https://github.com/mapbox/mapbox-maps-android/pull/780))
* Fix scale bar ratio setting not applied correctly. ([#827](https://github.com/mapbox/mapbox-maps-android/pull/827))
* Fix scale bar text missing for Android API 23. ([#839](https://github.com/mapbox/mapbox-maps-android/pull/839))
* Fix scale bar text being overlapped and clipped. ([#856](https://github.com/mapbox/mapbox-maps-android/pull/856))
* Fix puck jump to nullisland when location plugin settings are changed. ([#846](https://github.com/mapbox/mapbox-maps-android/pull/846))
* Fix scale listener events not being called for quick zoom doubleTap and doubleTouch gestures. ([#858](https://github.com/mapbox/mapbox-maps-android/pull/858))
* Release all unused resources when `MapboxMap.reduceMemoryUse` is invoked. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix crash for the case when an empty fill extrusion bucket is tried to be rendered. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix transparency issues with value < 0.5 for 3D puck models. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix regression where setting the same geojson source URL did not refresh the data. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix symbol layers with variable anchor placement not being placed correctly on globe view. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix crash in symbol reprojection code caused by division by zero. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))
* Fix issue with bounds constraining behavior when terrain is enabled. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))

## Dependencies
* Bump gl-native to v10.2.0-beta.2 and common to v21.0.0-rc.1. ([#852](https://github.com/mapbox/mapbox-maps-android/pull/852))

# 10.1.0 November 4, 2021

## Features ✨ and improvements 🏁
* Set thread priorities and set thread CPU affinity based on the thread's priority to improve overall map performance.([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Introduce option to enable multisample anti-aliasing (MSAA) for map rendering. ([#741](https://github.com/mapbox/mapbox-maps-android/pull/741))
* Add convenience methods for `stop` expression in Style DSL. ([#698](https://github.com/mapbox/mapbox-maps-android/pull/698), [#764](https://github.com/mapbox/mapbox-maps-android/pull/764))

## Bug fixes 🐞
* Avoid spawning extra AssetManagerFileSource threads when multiple instances of a MapView is created during application lifecycle. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix rendering artifact when some of the model layer models may have wrong placement when globe view projection is used. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix rare heatmap flickering when zooming the map. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix an issue where an Observable event could be dispatched on a thread, different from the subscription thread. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix an issue where promoteId parameter for VectorSource was overwritten when source tilejson is loaded ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix android glyph drawing issue when 'high contrast' text accessibility feature is turned on. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))
* Fix unexpectedly rapid map panning at high pitch level. ([#775](https://github.com/mapbox/mapbox-maps-android/pull/775))
* Fix map move using faster map offsetting after zoom-in or zoom-out gesture. ([#738](https://github.com/mapbox/mapbox-maps-android/pull/738))
* Fix annotation flickering and disappearing during dragging. ([#732](https://github.com/mapbox/mapbox-maps-android/pull/732))
* Fix logo and attribution margin update. ([#744](https://github.com/mapbox/mapbox-maps-android/pull/744))
* Fix `NullPointerException` while querying annotations. ([#746](https://github.com/mapbox/mapbox-maps-android/pull/746))
* Limit fast fling gesture in a downwards direction when map is highly pitched. ([#754](https://github.com/mapbox/mapbox-maps-android/pull/754))
* Fix an issue that caused annotations not being updated when style is loading other resources. ([#753](https://github.com/mapbox/mapbox-maps-android/pull/753))
* Restore the fling factor for slightly pitched maps. ([#762](https://github.com/mapbox/mapbox-maps-android/pull/762))

## Dependencies
* Bump gl-native to 10.1.0, common to 20.1.0. ([#810](https://github.com/mapbox/mapbox-maps-android/pull/810))

# 10.1.0-rc.1 October 28, 2021

## Bug fixes 🐞
* Fix unexpectedly rapid map panning at high pitch level. ([#775](https://github.com/mapbox/mapbox-maps-android/pull/775))
* Improve rendering performance by setting thread priorities and set thread CPU affinity based on the thread's priority. ([#774](https://github.com/mapbox/mapbox-maps-android/pull/774))

## Dependencies
* Bump gl-native to v10.1.0-rc, and common to v20.1.0-rc.2 ([#774](https://github.com/mapbox/mapbox-maps-android/pull/774))

# 10.1.0-beta.1 October 21, 2021

## Features ✨ and improvements 🏁
* Introduce option to enable Multisample anti-aliasing (MSAA) for map rendering. ([#741](https://github.com/mapbox/mapbox-maps-android/pull/741))
* Add convenience methods for stop expression. ([#698](https://github.com/mapbox/mapbox-maps-android/pull/698), [#764](https://github.com/mapbox/mapbox-maps-android/pull/764))

## Bug fixes 🐞
* Fix map move using faster map offsetting after zoom-in or zoom-out gesture. ([#738](https://github.com/mapbox/mapbox-maps-android/pull/738))
* Fix annotation flickering and disappearing during dragging. ([#732](https://github.com/mapbox/mapbox-maps-android/pull/732))
* Fix logo and attribution margin update. ([#744](https://github.com/mapbox/mapbox-maps-android/pull/744))
* Fix `NullPointerException` while querying annotations. ([#746](https://github.com/mapbox/mapbox-maps-android/pull/746))
* Limit fast fling gesture in a downwards direction when map is highly pitched. ([#754](https://github.com/mapbox/mapbox-maps-android/pull/754))
* Fixed an issue that caused annotations not being updated in some cases.. ([#753](https://github.com/mapbox/mapbox-maps-android/pull/753))
* Fix glyph drawing issue when the 'high contrast' text feature is turned on. ([#752](https://github.com/mapbox/mapbox-maps-android/pull/752))
* Fix `promoteId` parameter for VectorSource overwritten when source tilejson is loaded. ([#752](https://github.com/mapbox/mapbox-maps-android/pull/752))
* Avoid spawning extra AssetManagerFileSource threads. ([#752](https://github.com/mapbox/mapbox-maps-android/pull/752))
* Fix `NullPointerException` in `HttpResponseCallback`, when get an error message from the Exception. ([#752](https://github.com/mapbox/mapbox-maps-android/pull/752))
* Restore the fling factor for slightly pitched maps. ([#762](https://github.com/mapbox/mapbox-maps-android/pull/762))

## Dependencies
* Bump gl-native to v10.1.0-beta, and common to v20.1.0-rc.1 ([#752](https://github.com/mapbox/mapbox-maps-android/pull/752))


# 10.0.0 October 6, 2021

## Breaking changes ⚠️
* Add `@JvmOverloads` where applicable to provide better experience for Java users. ([#656](https://github.com/mapbox/mapbox-maps-android/pull/656))
* Refactor gestures configuration options to be aligned better across platforms. ([#672](https://github.com/mapbox/mapbox-maps-android/pull/672))
* Apply geojson data (using `data`, `url`, `feature`, `featureCollection`, `geometry` functions) is fully async now. ([#699](https://github.com/mapbox/mapbox-maps-android/pull/699))
* Update `getLayerAs` function to return nullable `Layer` type. ([#673](https://github.com/mapbox/mapbox-maps-android/pull/673))
* Update map events data models. ([#712](https://github.com/mapbox/mapbox-maps-android/pull/712))
* Refactor MapEvents listeners, so that each listener will include one event data property. ([#718](https://github.com/mapbox/mapbox-maps-android/pull/718))
* Abstract classes `CustomLayerHost`, `ElevationData`, `MapClient`, `Observer`, `OfflineRegionObserver`, `HttpServiceInterceptorInterface`, `HttpServiceInterface`, `LogWriterBackend`, `OfflineSwitchObserver`, `ReachabilityInterface`, `TileStoreObserver` have become interfaces. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))

## Features ✨ and improvements 🏁
* Introduce 3D globe (experimental). ([#667](https://github.com/mapbox/mapbox-maps-android/pull/667))
* Append gl-native and common API reference documentation to the output of Dokka documentation generation. ([#711](https://github.com/mapbox/mapbox-maps-android/pull/711))
* Set `Process.THREAD_PRIORITY_DISPLAY` as render thread priority to improve overall performance. ([#701](https://github.com/mapbox/mapbox-maps-android/pull/701))
* Add `HttpServiceFactory.reset()` to release the HTTP service implementation. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))

## Bug fixes 🐞
* Throw exception when gestures plugin functionality is used but plugin was not created. ([#653](https://github.com/mapbox/mapbox-maps-android/pull/653))
* Throw exception when camera plugin functionality is used but plugin was not created. ([#668](https://github.com/mapbox/mapbox-maps-android/pull/668))
* Fix black screen when resuming activity with `MapView` on x86 emulator, Android API <= 23. ([#671](https://github.com/mapbox/mapbox-maps-android/pull/671))
* Fix map render deadlock on Android 8 on power on button. ([#688](https://github.com/mapbox/mapbox-maps-android/pull/688))
* Fix context leak in `LocationProviderImpl`. ([#690](https://github.com/mapbox/mapbox-maps-android/pull/690))
* Fix native memory leak by explicitly nulling map reference from renderer. ([#687](https://github.com/mapbox/mapbox-maps-android/pull/687))
* Fix wrong attribute reference in runtime exception text when token is missing. ([#708](https://github.com/mapbox/mapbox-maps-android/pull/708))
* Fix applying position property to scale bar plugin. ([#677](https://github.com/mapbox/mapbox-maps-android/pull/677))
* Fix initialisation location puck when no style loaded from code by changing `Plugin#onStart()` call after style loaded started. ([#680](https://github.com/mapbox/mapbox-maps-android/pull/680))
* Fix attribution/logo jumble when RTL layout is configured. ([#674](https://github.com/mapbox/mapbox-maps-android/pull/674))
* Fix rendering artifacts for a model layer when `model-opacity` property is used. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))
* Improve rendering performance by avoiding unnecessary re-layout for cached tiles. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))
* Fix `onResponse` callback for `HttpInterceptor` never being called. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))

## Dependencies
* Bump gl-native to v10.0.0, common to v20.0.0. ([#697](https://github.com/mapbox/mapbox-maps-android/pull/697))

# 10.0.0-rc.9 September 22, 2021

## Features ✨ and improvements 🏁
* Fix documentation for `OnMapIdleListener` and `CameraChangeListeners`. ([#645](https://github.com/mapbox/mapbox-maps-android/pull/645))
* Add support for `SymbolZOrder` property in PointAnnotationManager. ([#638](https://github.com/mapbox/mapbox-maps-android/pull/638))
* Add support for `PromoteId` to be used with Feature State API. ([#636](https://github.com/mapbox/mapbox-maps-android/pull/636))
* Expose `optimizeForTerrain` flag (default to true) that could be applied to the `MapView` in xml. When optimizeForTerrain is enabled, layers could get reordered to achieve the best performance. ([#654](https://github.com/mapbox/mapbox-maps-android/pull/654))
* Enable instant transitions for data driven symbol layer properties. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))

## Bug fixes 🐞
* `OnStyleLoaded` / `OnMapLoaded` callbacks are invoked even if hosting fragment/activity is in stopped state. ([#629](https://github.com/mapbox/mapbox-maps-android/pull/629))
* Fix drag annotation blink when drag ends. ([#639](https://github.com/mapbox/mapbox-maps-android/pull/639))
* Apply annotation manager properties to the drag layer to keep annotations the same while dragging. ([#640](https://github.com/mapbox/mapbox-maps-android/pull/640))
* Fix point annotation updating all same content bitmaps instead of one particular. ([#633](https://github.com/mapbox/mapbox-maps-android/pull/633))
* Fix `MapboxMap#getStyle` returning null after adding a new source when style was loaded before. ([#643](https://github.com/mapbox/mapbox-maps-android/pull/643))
* Allow setting null explicitly to annotation nullable properties. ([#650](https://github.com/mapbox/mapbox-maps-android/pull/650))
* Fix `std::exception` happing rarely when `MapboxMap#setCamera()` is called inside animation plugin. ([#652](https://github.com/mapbox/mapbox-maps-android/pull/652))
* Fix memory leak in renderer destroy. ([#657](https://github.com/mapbox/mapbox-maps-android/pull/657))
* Fix transition between layers with all constant properties. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))
* Fix rendering artifact for a line layer, when its `line-gradient` property is set at runtime. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))
* Don't draw SDF images in `text-field` and issue warning for it. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))
* Fix incorrect return from StyleManager#getStyleLayerPropertyDefaultValue for `text-field`, now the default value is set to `["format", "" , {}]`. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))

## Dependencies
* Bump gl-native to 10.0.0-rc.9, common to 19.0.0. ([#646](https://github.com/mapbox/mapbox-maps-android/pull/646))

# 10.0.0-rc.8 September 8, 2021

## Breaking changes ⚠️
* In offline mode (set by either mapbox::common::OfflineSwitch API or on platform side), the error notifications are send if the required resources are not present locally. The volatile tiles are not considered to be required in offline.([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Adapt setBounds to gl-js behavior: constraining of coordinates and zoom level is now stricter to prevent out of bounds map area to be visible in the viewport.([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Add HTTP interceptor API - for anyone who is using HttpServiceInterface; there is a new method called setInterceptor that should be overridden([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))

## Features ✨ and improvements 🏁
* Make 3D puck always over (in front of) 3D layers (buildings, landmarks, custom layer) but behind hill (terrain). ([#601](https://github.com/mapbox/mapbox-maps-android/pull/601))
* Integrate value marshalling performance improvement ([#606](https://github.com/mapbox/mapbox-maps-android/pull/606))
* Introduce drag layer/source for annotation plugin to improve drag performance. ([#582](https://github.com/mapbox/mapbox-maps-android/pull/582))
* Update prefetch zoom delta documentation to match actual behavior ([#609](https://github.com/mapbox/mapbox-maps-android/pull/609))
* Add support for the index-of and slice expressions ([#616](https://github.com/mapbox/mapbox-maps-android/pull/616))
* Improve collision detection by using runtime calculated sizes for collision boxes. Previously collision boxes' sizes are constant, they are calculated during symbol layout time by using constant zoom level([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Improve collision detection by using runtime calculated pixelated sizes for collision circles. Previously collision circles' sizes are constant, they are calculated during symbol layout time by using constant zoom level([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Implement 'promoteId' feature for geojson and vector sources. The feature allows to promote feature's property to a feature id, so that promoted id can be used with FeatureState API.([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Enable instant transitions for data driven paint layer properties([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))

## Bug fixes 🐞
* Use touch focal point to calculate the correct scroll displacement when the map is pitched. ([#593](https://github.com/mapbox/mapbox-maps-android/pull/593))
* Use touch focal point to calculate the correct fling displacement. ([#599](https://github.com/mapbox/mapbox-maps-android/pull/599))
* Allow geojson source to initialise with empty data. ([#602](https://github.com/mapbox/mapbox-maps-android/pull/602))
* Preserve EGL setup on renderer stop. This fixes full map reloading when map is brought out from background. ([#598](https://github.com/mapbox/mapbox-maps-android/pull/598))
* Fix issue with camera animators ordering on Android 6 and lower by revisiting overall approach of applying accumulated camera changes. ([#597](https://github.com/mapbox/mapbox-maps-android/pull/597))
* Enable update bitmap for annotations  ([#615](https://github.com/mapbox/mapbox-maps-android/pull/615))
* Fix volatile tiles disappearing on "not modified" response([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Prioritize addition of a persistent layer whose id is used for other persistent layer positions([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Only do line breaking process for point placement labels. And if text-max-width is 0, still do general ideographic beaking checks for point labels.([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Fix collision box's 'dynamicVerticesExt' updating in placement stage([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))
* Trigger map redraw when feature state changes ([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))

## Dependencies
* Bump gl-native to 10.0.0-rc.8, common to 18.0.0 ([#604](https://github.com/mapbox/mapbox-maps-android/pull/604))

# 10.0.0-rc.7 August 25, 2021

## Breaking changes ⚠️
* Remove the expression getter/setters for source properties. ([#568](https://github.com/mapbox/mapbox-maps-android/pull/568))

## Features ✨ and improvements 🏁
* Add generateId property for GeoJsonSource. ([#538](https://github.com/mapbox/mapbox-maps-android/pull/538))
* Add default value to improve usability of FeatureState API. ([#588](https://github.com/mapbox/mapbox-maps-android/pull/588))
* Add Style#moveStyleLayer(layerId: String, layerPosition: LayerPosition?): Expected<String, None> API ([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))
* Allow using combination of line-dasharray and line-gradient for line layer. ([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))

## Bug fixes 🐞
* Remove strong ref dependency in snapshotter that was leading to a memory leak if Snapshotter#destroy was not called explicitly. ([#571](https://github.com/mapbox/mapbox-maps-android/pull/571))
* Fix get annotation enum property crash ([#579](https://github.com/mapbox/mapbox-maps-android/pull/579))
* Fix rendering issue for round line-join in line gradients ([#565](https://github.com/mapbox/mapbox-maps-android/pull/565))
* A fix of the layer paint property evaluation while transitioning from a data-driven value. It snaps immediately to the new value thus preventing of drawing stale data during the animation.([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))
* Reduced memory consumption when using raster layers by deleting CPU side tile bitmap copy after uploading to GPU texture.([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))
* Fix crash on Android when using tile requests delay API([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))

## Dependencies
* Bump gl-native to v10.0.0-rc.7, common to v17.0.0 ([#563](https://github.com/mapbox/mapbox-maps-android/pull/563))
* Bump gl-native to v10.0.0-rc.7.1. ([#565](https://github.com/mapbox/mapbox-maps-android/pull/565))
* Bump gl-native to v10.0.0-rc.7.2, common to 17.1.0 ([#575](https://github.com/mapbox/mapbox-maps-android/pull/575))
* Bump targetSDKVersion and compileSDKVersion to 30, robolectric version to 4.6.1. ([#514](https://github.com/mapbox/mapbox-maps-android/pull/514))

# 10.0.0-rc.6 August 11, 2021

## Breaking changes ⚠️
* Update extension function signatures making them easier to use from Java. ([#539](https://github.com/mapbox/mapbox-maps-android/pull/539))
* Rename `mapView#overlay()` to `mapView#mapboxOverlay`. ([#539](https://github.com/mapbox/mapbox-maps-android/pull/539))

## Features ✨ and improvements 🏁
* Support adding 9-patch images to the style. ([#536](https://github.com/mapbox/mapbox-maps-android/pull/536))
* Outdated data for volatile sources gets hidden if cannot be updated due to no Internet connection. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))

## Bug fixes 🐞
* Fix several memory leaks: clean up OnFpsChangeListener on render thread destroy / introduce Snapshotter#destroy method that must be called in Activity#onDestroy ([#546](https://github.com/mapbox/mapbox-maps-android/pull/546))
* Add layer and source check when creating annotations and init them if not initiated before which creates `AnnotationManager` before loading style. ([#549](https://github.com/mapbox/mapbox-maps-android/pull/549))
* Fix error messages returned by `Style#removeStyleSource` method. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))
* Store persistent layer's LayerPosition, so that layer can be re-added to correct position if LayerPosition.above or LayerPosition.at is used. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))

## Dependencies
* Update gl-native to v10.0.0-rc.6 and common to v16.2.0. ([#543](https://github.com/mapbox/mapbox-maps-android/pull/543))
* Remove turf dependency of location component plugin. ([#551](https://github.com/mapbox/mapbox-maps-android/pull/551))

# 10.0.0-rc.5 July 28, 2021

## Breaking changes ⚠️
* Improve camera API consumption from java programming language by adding `CameraAnimationsUtils` and `getCamera` JvmName annotations. ([#495](https://github.com/mapbox/mapbox-maps-android/pull/495))
* Rename `AttributionView#setOnClickListener` to `setViewOnClickListener` to avoid overloading the Android SDK method. Results in compilation on Android P and above. Adjust codebase to changes in enforced nullability of Android SDK code. ([#497](https://github.com/mapbox/mapbox-maps-android/pull/497))
* Get rid of using reflection when creating plugins which should decrease `MapView` startup time if plugins are enabled. ([#519](https://github.com/mapbox/mapbox-maps-android/pull/519))

## Features ✨ and improvements 🏁
* Add `showLogo` and `showAttributes` config for snapshotter which are defaulted to true. User can now hide logo and attributions in a snapshotter by changing this config ([#496](https://github.com/mapbox/mapbox-maps-android/pull/496))
* Add lifecycle plugin so there is no need to call `onStart`/`onStop`/`onDestroy`/`onLowMemory` methods explicitly, if the appcompact 1.3.0+ is used. ([#485](https://github.com/mapbox/mapbox-maps-android/pull/485))
* Add a minimum Android Auto test app and an optional Android Auto extension that provide convenient extension function to initialise the MapSurface from a Car App Session. ([#488](https://github.com/mapbox/mapbox-maps-android/pull/488))
* Add lint check for lifecycle methods ([#516](https://github.com/mapbox/mapbox-maps-android/pull/516))

## Bug fixes 🐞
* Fix issues with MapView#snapshot methods that could cause black snapshot or ANR in some cases. ([#508](https://github.com/mapbox/mapbox-maps-android/pull/508))

# 10.0.0-rc.4 July 14, 2021

**The Mapbox Maps SDK for Android has moved to release candidate status and is now ready for production use.**

## Features ✨ and improvements 🏁
* Add new param to allow users localize selected layers. ([#461](https://github.com/mapbox/mapbox-maps-android/pull/461))
* Add API to control logging for animation plugin and disable debug logs by default. ([#474](https://github.com/mapbox/mapbox-maps-android/pull/474))
* Introduce option to use continuous rendering for scale bar. Continuous render mode will fix gfxinfo profiling. ([#458](https://github.com/mapbox/mapbox-maps-android/pull/458))
* Add shortest bearing path option for animators. ([#473](https://github.com/mapbox/mapbox-maps-android/pull/473))
* Add modelTranslation support for LocationPuck3D ([#493](https://github.com/mapbox/mapbox-maps-android/pull/493))
* Add default parameters to coordinate conversion functions of MapCameraManagerDelegate#cameraForCoordinates, MapCameraManagerDelegate#cameraForCoordinateBounds and MapCameraManagerDelegate#cameraForGeometry. This overloads the functions to have a more simple API surface for developers to hook into. ([#491](https://github.com/mapbox/mapbox-maps-android/pull/491))
* Support text-writing-mode property for line symbol-placement text labels (#1766)
  Note: This change will bring following changes for CJK text block:
  - For vertical CJK text, all the characters including Latin and Numbers will be vertically placed now. Previously, Latin and Numbers are horizontally placed.
  - For horizontal CJK text, it may have a slight horizontal shift due to the anchor shift.
* Session SKU generation is now available
* Add getSKUTokenIfValid to get a SKU token for a SKU identifier if it exists and is not expired, return empty string if not.
* Allow filtering of log messages by categories.
* Expose isFiltered for checking logging category settings

## Bug fixes 🐞
* Fix flyTo crash when using single-pixel paddings. ([#478](https://github.com/mapbox/mapbox-maps-android/pull/478))
* Fixed regression in map gestures on devices with Android 6 and lower. ([#484](https://github.com/mapbox/mapbox-maps-android/pull/484))
* Fix overwriting sync geojson data with getSourceAs by async. ([#482](https://github.com/mapbox/mapbox-maps-android/pull/482))
* Clean up network listener after http file source gets out of scope
* Fix line-center anchor calculation when the anchor is very near to the line geometry point
* Fix crash when a Feature State API is used with dedicated rendering thread
* Fix threading issues in HTTP file source
* Fix volatile tilesets handling

## Dependencies
* Update gl-native to v10.0.0-rc.5 and common to v16.0.0. ([#487](https://github.com/mapbox/mapbox-maps-android/pull/487))

# 10.0.0-rc.3 June 30, 2021

**The Mapbox Maps SDK for Android has moved to release candidate status and is now ready for production use.**

## Breaking changes ⚠️
* Perform annotation click synchronously and change AnnotationManagerImpl#queryMapForFeatures function to be synchronous. ([#455](https://github.com/mapbox/mapbox-maps-android/pull/455))

## Features ✨ and improvements 🏁
* Introduce static MapboxMap.clearData(resourceOptions: ResourceOptions, callback: AsyncOperationResultCallback) API and MapboxMap#clearData(callback: AsyncOperationResultCallback), Snapshotter#clearData(callback: AsyncOperationResultCallback) APIs. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))
* Optimise the Style#getLayer and Style#getSource APIs' performance. ([#449](https://github.com/mapbox/mapbox-maps-android/pull/449))
* MapEvents#MAP_LOADING_ERROR events now include source and tile information where appropriate. New fields would allow developers to understand what source or tile has failed to load and the reason for a failure. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))

## Bug fixes 🐞
* Fix dropping annotation source updates if those were emitted rapidly without handler. ([#441](https://github.com/mapbox/mapbox-maps-android/pull/441))
* Fix raster/v1 terrain tiles fetch failures caused by appending pixel ratio to the URLs when tile size is equal to 512. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))
* Fixed an issue that the LayerPosition is not persisted across the style change, when using persistent layer based annotation plugin and location component plugin. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))
* Disable MapboxTelemetryInitProvider if the telemetry is disabled via app's manifest reducing startup time. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))

## Dependencies
* Bump gl-native to v10.0.0-rc.3, common to v14.2.0. ([#442](https://github.com/mapbox/mapbox-maps-android/pull/442))
* Bump telemetry to 8.1.0. ([#457](https://github.com/mapbox/mapbox-maps-android/pull/457))

# 10.0.0-rc.2 June 23, 2021

## Features ✨ and improvements 🏁
* Introduce experimental `Style#addPersistentLayer`, `Layer#isPersistent`, `Style#addPersistentStyleLayer`, `Style#addPersistentStyleCustomLayer` and `Style#isStyleLayerPersistent` APIs, so that the tagged layer and its associated resources would remain when a style is reloaded. This improves performance of Annotation and Location Component Plugin during the style change. ([#368](https://github.com/mapbox/mapbox-maps-android/pull/368), ([#422](https://github.com/mapbox/mapbox-maps-android/pull/422)))
* Add Localization API to apply languages to the style by provided locale. ([#379](https://github.com/mapbox/mapbox-maps-android/pull/379))
* Reduce unnecessary render cache texture updates by introducing a small delay after zoom has changed.
* Save and read application state on a background thread, to avoid delays (~3-5ms) on the main thread.

## Bug fixes 🐞
* Introduce size check for render cache. ([#425](https://github.com/mapbox/mapbox-maps-android/pull/425))
* Fix memory leak on render destroy. ([#426](https://github.com/mapbox/mapbox-maps-android/pull/426))
* Changes the visibility of jsonObject in annotation to protected, fix ConcurrentModificationException ([#427](https://github.com/mapbox/mapbox-maps-android/pull/427))
* Fix camera deadlock use-case. ([#439](https://github.com/mapbox/mapbox-maps-android/pull/439))
* Tileset descriptor resolving fixes:
  - Operation completes even if the offline manager instance gets out of scope
  - Fixes leaking TilesetResolverObserver instance
  - Fixes possible crash on cancellation of pending style pack download operation
* Fix text rendering when both 'text-rotate' and 'text-offset' are set.
* Fix Android 12 compatibility to support [pending intents mutability](https://developer.android.com/about/versions/12/behavior-changes-12#pending-intent-mutability).

## Dependencies
* Bump gl-native to v10.0.0-rc.2 ([#422](https://github.com/mapbox/mapbox-maps-android/pull/422))
* Bump telemetry to v8.0.0, android core to v5.0.0 ([#423](https://github.com/mapbox/mapbox-maps-android/pull/423))

# 10.0.0-rc.1 June 10, 2021

## Breaking changes ⚠️
* Rename setter for `Light` object from `add` to `set`. This matches API from GL-JS and clarifies there is only 1 Light object. ([#387](https://github.com/mapbox/mapbox-maps-android/pull/387))
* Rename setter for `Terrain` object from `add` to `set`. ([#391](https://github.com/mapbox/mapbox-maps-android/pull/391))
* Remove `CacheManager`. In the following releases, an API to control temporary map data may be provided. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Remove `ResourceOptions::cacheSize` and `DefaultAmbientCacheSize` constant. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Replace `ResourceOptions::cachePath` with `ResourceOptions::dataPath` that accepts a folder in which the map stores offline style packages and temporary map data. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Rename `TileStore::getInstance()` to `TileStore::create()`. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Remove the `MapView#setRenderCache` and `MapSurface#setRenderCache` API and replaced them with experimental `MapboxMap#setRenderCacheOptions` and `MapboxMap#getRenderCacheOptions` APIs. ([#401](https://github.com/mapbox/mapbox-maps-android/pull/401))
* Change the default `ResourceOptions#dataPath` to `${context.filesDir.absolutePath}/.mapbox/map_data/` and the database name from `ambient_cache.db` to `map_data.db`. ([#403](https://github.com/mapbox/mapbox-maps-android/pull/403))

## Features ✨ and improvements 🏁
* The amount of the unique maps tile packs used in the offline regions is capped by the maximum amount equal to 750. The tile region loading is not be performed if it would cause exceeding of the tile pack limit. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))

## Bug fixes 🐞
* Fix a typo in `MapboxMapUtils` jvm name. ([#396](https://github.com/mapbox/mapbox-maps-android/pull/396))
* Fix an issue that vertical text was not positioned correctly if the `text-offset` property was used. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Emit `MapLoadingError` when an empty token is provided for accessing Mapbox data sources. Before the fix, the application may crash if an empty token was provided and map tries to load data from Mapbox data source. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Create folder structure for provided `ResourceOptions#dataPath` when a provided folder doesn't exist. Before the fix, map expected the folder to exist, and in case it didn't, it was difficult to report an error to the application. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Do not emit `MapLoadingError` when an empty URL is set to GeoJSON source. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Avoid packaging `gms-play-services-location` by default as part of the Android SDK. ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))
* Fix an issue that causes public resource definitions not generated in public.txt file. ([#404](https://github.com/mapbox/mapbox-maps-android/pull/404))

## Dependencies
* Bump gl-native to v10.0.0-rc.1, common to v14.0.1 ([#399](https://github.com/mapbox/mapbox-maps-android/pull/399))

# 10.0.0-beta.21- June 3, 2021
## Breaking changes ⚠️
* Align load style functions for MapboxMap and Snapshotter. ([#371](https://github.com/mapbox/mapbox-maps-android/pull/371))
* Change the default ambient cache path to `.mapbox/maps/ambient_cache.db` ([#373](https://github.com/mapbox/mapbox-maps-android/pull/373))
* Move text-font property from PointAnnotation to PointAnnotationManager ([#375](https://github.com/mapbox/mapbox-maps-android/pull/375))
* Remove CredentialsManager in favour of ResourceOptionsManager ([#365](https://github.com/mapbox/mapbox-maps-android/pull/365))
* Introduce separate minZoom/maxZoom fields into CustomGeometrySourceOptions API instead of the formerly used "zoomRange"

## Features ✨ and improvements 🏁
* Rework setPrefetchZoomDelta to reduce loading of expensive tiles and optimize zoom use-case (#1850)
* Send billing event when Map is loaded 

## Bug fixes 🐞
* Fixed an issue that causes OnStyleLoaded callback not fired when there's a sprite loading error. ([#358](https://github.com/mapbox/mapbox-maps-android/pull/358))
* Update map camera on first animator update. ([#352](https://github.com/mapbox/mapbox-maps-android/pull/352))
* Fix crash due to missing access token ([#365](https://github.com/mapbox/mapbox-maps-android/pull/365))
* Call style loaded callback if data set directly to geojson. ([#377](https://github.com/mapbox/mapbox-maps-android/pull/377))
* Geojson async data parsing: fixes and improvements. ([#380](https://github.com/mapbox/mapbox-maps-android/pull/380))
* Fix terrain transparency issue when a sky layer is not used
* Make style pack resources immutable protecting the style pack from getting out of sync in case the style is updated remotely

## Dependencies
* Bump glNative to 10.0.0-beta.23, common to 13.0.0 ([#362](https://github.com/mapbox/mapbox-maps-android/pull/362))
* Bump mapbox-events-android to latest releases telem-7.0.3 and core-4.0.2 ([#370](https://github.com/mapbox/mapbox-maps-android/pull/370))

# 10.0.0-beta.20 - May 20, 2021
## Breaking changes ⚠️
* Introduce ResourceOptionsManager to configure the default resource options, and removed the xml configuration options for cache path and tile store path. ([#339](https://github.com/mapbox/mapbox-maps-android/pull/339))
* Rename default ambient cache database to mapbox/maps/ambient_cache.db  ([#314](https://github.com/mapbox/mapbox-maps-android/pull/314))
* Remove the usage of asset path from the codebase, as it is not useful in Android Maps SDK. ([#334](https://github.com/mapbox/mapbox-maps-android/pull/334))
* Rename `NetworkConnectivity` to `OfflineSwitch`.
* Remove `TileLoadOptions` from `TileRegionLoadOptions`. `networkRestriction` and `acceptExpired` can now be specified directly in `TileRegionLoadOptions`.
* Add `totalBytes` and `transferredBytes` to TileStoreLoadResult.
* `MapboxMap.setBounds` return type changed from Void to Expected.
* Expose tileset version for sources that use TileJSON metadata.
* ResourceRequest `offline-data` boolean field is replaced with the `source` string field, which whether the response came from network, cache or tile store.
* Remove `Style.getStyleGeoJSONSourceClusterLeaves`, `Style.getStyleGeoJSONSourceClusterExpansionZoom`, `Style.getStyleGeoJSONSourceClusterChildren`. All those can be fully replaced by `MapboxMap.queryFeatureExtensions`.
* Parsing geojson on a worker thread. Using DSL GeoJsonSource builders with the following functions `GeoJsonSource.Builder#feature`, `GeoJsonSource.Builder#featureCollection`, `GeoJsonSource.Builder#geometry` will immediately returns GeoJsonSource with no data set and starts preparing actual data using a worker thread. The data will be set to the GeoJsonSource once parsed. ([#327](https://github.com/mapbox/mapbox-maps-android/pull/327))

## Features ✨ and improvements 🏁
* Add a `cameraOptions(cameraState, builderBlock)` inline method that helps mutate an existing `CameraState` object. ([#317](https://github.com/mapbox/mapbox-maps-android/pull/317))
* Add selected state handling to annotation plugin ([#316](https://github.com/mapbox/mapbox-maps-android/pull/316))
* Add API for disabling vertical/horizontal scroll gestures ([#319](https://github.com/mapbox/mapbox-maps-android/pull/319))
* Introduce API to enable render cache feature that could bring up rendering performance improvement. ([#326](https://github.com/mapbox/mapbox-maps-android/pull/326))
* Add `removeAnnotationManager` API. ([#330](https://github.com/mapbox/mapbox-maps-android/pull/330))
* Improve terrain's rendering performance 
* Set `begin` and `end` timestamps for StyleLoaded and MapLoaded events, so that developers could check how much time it takes to load style and map, respectively
* Added `tile-requests-delay` and `tile-network-requests-delay` runtime source properties - an API for tile requests delay
* Introduce MapOptions.optimizeForTerrain option that allow style rendering optimizations for terrain rendering
* The `text-line-height` is now data-driven property
* MapLoaded, StyleLoaded and StyleDataLoaded events now contain begin and end timestamps reflecting the effective duration timespan
* When line lablels are inside the flip state retaining range (+/- 5 degrees around the vertical direction), the lables' flip state will be kept the same
* Improve rendering quality of fill outlines when using render cache

## Bug fixes 🐞
* Fix scalebar doesn't refresh issue. ([#331](https://github.com/mapbox/mapbox-maps-android/pull/331))
* Trigger nested high-level animator listener correctly. ([#335](https://github.com/mapbox/mapbox-maps-android/pull/335))
* Make compass visible when camera was mutated while compass was disabled. ([#322](https://github.com/mapbox/mapbox-maps-android/pull/322))
* Enable LocationComponent automatically when style loaded; fix null island location puck ([#333](https://github.com/mapbox/mapbox-maps-android/pull/333))
* Fix crash if the belowLayerId doesn't exist on the current style ([#330](https://github.com/mapbox/mapbox-maps-android/pull/330))
* Fixed an issue that style pack download cancels pending tileset descriptor resolving, now tile region loading and style pack loading can work in parallel.
* Fixed the excessive network usage during map browsing caused by losing of the expiration date and the etag for the cached files
* Fix excessive network usage for delayed tile requests
* On style pack update we reset only glyphs and only when the updated options require less glyphs than currently available and we make sure ambient cache size limit is never exceeded
* Emit `StyleDataLoaded` and `SourceDataLoaded` synchronously if possible, so that developers could modify style and sources before map starts rendering style
* Fix occasional Adreno 640 and 620 driver warnings and deadlock when terrain is used
* Fix rendering order of transparent terrain proxy tiles

## Dependencies
* Update telemetry (v7.0.1) and core (v4.0.1) dependencies to latest major version releases ([#337](https://github.com/mapbox/mapbox-maps-android/pull/337))
* Bump gl-native to v10.0.0-beta.22 and common to v12.0.0. ([#338](https://github.com/mapbox/mapbox-maps-android/pull/338))

# 10.0.0-beta.19 - May 5, 2021
## Breaking changes ⚠️
* Remove temporary CustomMapInterface used for testing, obsolete with having interface inheritance from upstream. ([#296](https://github.com/mapbox/mapbox-maps-android/pull/296))
* Align MapCameraManagerDelegate with MapCameraManagerInterface ([#293](https://github.com/mapbox/mapbox-maps-android/pull/293))
* Refactor CameraOptions and change `MapboxMap.getCameraState` method to return non-nullable CameraState record
* Remove `MapboxMap.getMinZoom`, `MapboxMap.getMaxZoom` and `MapboxMap.getScale` methods that are duplicate of functionality provided by `MapboxMap.getBounds`. `MapboxMap.getBounds` returns new CameraBounds type with non-nullable fields.
* Remove `MapboxMap.setDefaultFramebufferObject`.
* Remove `MapboxMap.dumpDebugLog`.
* Remove `isPanning`, `isRotating`, `isScaling` and `cancelTransitions` methods from MapboxMap. Controlling map animations should be done with camera animation plugin.
* Remove following methods from MapCameraManagerDelegate (formerly MapCameraDelegate): getLan(), getLon(), getPitch(), getBearing(), getPadding(), setBearing(double). Those properties could be accessed now from MapCameraManagerDelegate.cameraState directly.

### OfflineManager and CacheManager
* Introduce TileStoreUsageMode enum and use it in resource options. New enum allows to set tile store usage mode in an non ambiguous way.
* Cache manager asynchronous  calls complete even after the cache manager instance gets out of scope on the client side. Fix possible crash on setDatabasePath() call
* CacheManager::prefetchAmbientCache() semantics is updated


## Features ✨ and improvements 🏁
* Add styleUri property in MapInitOptions ([#287](https://github.com/mapbox/mapbox-maps-android/pull/287))
* Refactored plugin system to have more granular control over which plugins are loaded when creating a MapView programmatically. ([#231](https://github.com/mapbox/mapbox-maps-android/pull/231))
* Instrument tests for offline ([#290](https://github.com/mapbox/mapbox-maps-android/pull/290))
* Cleanup kdoc documentation, remove html tags ([#305](https://github.com/mapbox/mapbox-maps-android/pull/305))
* Reduce GPU memory usage by reusing depth stencil buffer for terrain rendering


## Bug fixes 🐞
* Request layout when updating ornaments margins, making updates immediate ([#292](https://github.com/mapbox/mapbox-maps-android/pull/292))
* Remove runtime plugin dependency for legacy location plugin. ([#295](https://github.com/mapbox/mapbox-maps-android/pull/295))
* Fix an issue that causes the extension functions not discoverable from downstream projects. ([#299](https://github.com/mapbox/mapbox-maps-android/pull/299))
* Style and map error loading listeners are only called for the style that was associated to the listeners when style loading started. This avoid calling the wrong listeners with multiple style loads. Renamed Style#isStyleLoadInited to Style#isStyleLoadInitiated. ([#300](https://github.com/mapbox/mapbox-maps-android/pull/300))
* Fix crash if doing setCamera during map loading ([#310](https://github.com/mapbox/mapbox-maps-android/pull/310))
* Fix map rendering issue when `text-field`'s inline images used with complex case expressions
* Fix erroneous font eviction when `text-field`'s formatted sections have `text-font` overrides
* Fix Adreno specific crash that happens when terrain is enabled
* Fix OfflineManager network errors handling
* Fix map rendering issue when feature-state and terrain features are enabled
* The ResourceRequest event response.offline-data field now indicates whether or not the response came from tile store


## Dependencies
* Bump to gl-native v10.0.0-beta.21, update common v11.0.2. ([#304](https://github.com/mapbox/mapbox-maps-android/pull/304))

# 10.0.0-beta.18 - April 22, 2021
## Breaking changes ⚠️
* Rename MapView plugin extension functions. ([#272](https://github.com/mapbox/mapbox-maps-android/pull/272))
  - mapView.getAnnotationPlugin() -> mapView.annotations
  - mapView.getGesturesPlugin() -> mapView.gestures
  - mapView.getOverlayPlugin() -> mapView.overlay() // using function here because of experimental annotation
  - mapView.getLocationComponentPlugin() -> mapView.location
  - mapView.getCameraAnimationsPlugin() -> mapView.camera
  - mapView.getAttributionPlugin() -> mapView.attribution
  - mapView.getCompassPlugin() -> mapView.compass
  - mapView.getLogoPlugin() -> mapView.logo
  - mapView.getScaleBarPlugin() -> mapView.scalebar
* Remove deprecated location plugin ([#276](https://github.com/mapbox/mapbox-maps-android/pull/276))
* Add feature sdk initialisation ([#269](https://github.com/mapbox/mapbox-maps-android/pull/269))
  - Load the Mapbox Street style by default if user doesn't load any style before the onStart lifecycle event.
  - Introduce `CredentialsManager` to manage mapbox access token, when all `MapView`s should use same token could be handled by using `CredentialsManager.shared` static object.
  - Introduce `MapInitOptions` to replace MapboxMapOptions. 
## Features ✨ and improvements 🏁
* High-level animations return cancelable interface ([#262](https://github.com/mapbox/mapbox-maps-android/pull/262))
* Introduce OfflineManager API that manages style packs and produces tileset descriptors for the tile store.
  - By default, users may download up to 250MB of data for offline use without incurring additional charges. This limit is subject to change during the beta.
  - The new API replaces the deprecated OfflineRegionManager API. The OfflineManager API can be used to create offline style packs that contain style data, such as: style definition, sprites, fonts and other resources. Tileset descriptors created by the OfflineManager API are used to create tile packs via TileStore API. Mobile maps SDKs use tile packs for rendering map content. 
* Add offline activity example. ([#259](https://github.com/mapbox/mapbox-maps-android/pull/259))
* Load the Mapbox Street style by default if user doesn't load any style before the onStart lifecycle event([#248](https://github.com/mapbox/mapbox-maps-android/pull/248))

## Bug fixes 🐞
* Keep CompassPlugin enabled/disabled state after other properties update ([#252](https://github.com/mapbox/mapbox-maps-android/pull/252))
* Fix disabling logo in xml. ([#273](https://github.com/mapbox/mapbox-maps-android/pull/273))
* Introduce StyleInterface that include the current display's pixel ratio, and fix Style#addImage to take the correct pixel ratio from display.  ([#228](https://github.com/mapbox/mapbox-maps-android/pull/228))
* Properly reset anchor after some gestures。 ([#279](https://github.com/mapbox/mapbox-maps-android/pull/279))
* Remove animator cancel listeners logic duplicating end listeners logic. ([#280](https://github.com/mapbox/mapbox-maps-android/pull/280))

## Dependencies
* Bump gl-native to v10.0.0-beta.20, common to v11.0.1 ([#261](https://github.com/mapbox/mapbox-maps-android/pull/261))

# 10.0.0-beta.17 - April 14, 2021
## Breaking changes ⚠️
* [Annotation plugin] Rename annotation classes, the rules are as follows and applied for Annotations/Options/Managers ([#227](https://github.com/mapbox/mapbox-maps-android/pull/227))
    - Symbol -> PointAnnotation
    - Circle -> CircleAnnotation
    - Line -> PolylineAnnotation
    - Fill -> PolygonAnnotation
* mapboxMap.queryRenderedFeatures will return a new data class QueriedFeature which will contain additional properties ([#247](https://github.com/mapbox/mapbox-maps-android/pull/247)): 
    - source (id of the source)
    - sourceLayer (id of the source's layer)
    - state (feature's state) 
* Rename Style#isStyleFullyLoaded to Style#isStyleLoaded
* Remove old map#drag API and the AnimationOptions API
* Don't emit MapIdle event when there is gesture and / or user animation in progress
* Make overlay plugin experimental ([#233](https://github.com/mapbox/mapbox-maps-android/pull/233))

## Features ✨ and improvements 🏁
* Introducing NetworkConnectivity API (offline switch). If setting setMapboxStackConnected(false), the Reachability API will report NotReachable, http requests are being blocked and if running, cancelled.
* Added new CameraManager.cameraForCoordinates overload
* Added support for query rendered features for Circle Layer on Terrain
* Enable identical code folding and -lto-O3 optimizations to reduce binary size of native map shared library

## Bug fixes 🐞
* Fix runtime crash if logo / attribution not enabled ([#240](https://github.com/mapbox/mapbox-maps-android/pull/240))
* Fixed a bug that causes map not loading when connected through ethernet.
* Fix distance expression parsing for geometries containing over 20k points
* Fixed holes in the ground for terrain with negative elevation
* Make StyleImageMissing callback a no-op after ImageManager destruction
* Reset unprocessed event queue for destructed renderer
* Fix clipping of fill-extrusions on near plane
* Set 'clusterMaxZoom' to be 'maxZoom-1' when it is not provided
* Fix crash for the case when MapSnapshotter object is destructed from within user provided callback
* Terrain render cache now disabled during property transitions
* Fix missing terrain tiles when camera is on mountain peak
* Black screen not used during loading anymore, prefering platform background
* Emit CameraChanged, SourceAdded(Removed) and StyleImageMissing events synchronously

## Dependencies
* [deps] Bump gl-native to v10.0.0-beta.19, common to v11.0.0 ([#247](https://github.com/mapbox/mapbox-maps-android/pull/247))

# 10.0.0-beta.16 - March 25, 2021

## Breaking changes ⚠️
* Remove ModelLayer and ModelSource API ([#128](https://github.com/mapbox/mapbox-maps-android/pull/128))
* Refactor Event API into new Observers. ([#166](https://github.com/mapbox/mapbox-maps-android/pull/166))
* Bump minSdkVersion of the SDK to 21, and bumped okhttp dependency to v4.9.0. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Rename jumpTo(options: CameraOptions) to setCamera(options: CameraOptions), rename setFreeCameraOptions (options: FreeCameraOptions) to setCamera(options: FreeCameraOptions). ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Rename OnMapLoadingFinishedListener to OnMapLoadedListener. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Introduce OnStyleDataLoadedListener to replace OnStyleLoadingFinishedListener, and introduce OnSourceDataLoadedListener to replace OnSourceChangedListener. So that developers have granular control of style/source loading status. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Introduce coordinateBoundsForCamera() API to replace the getRegion() API. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Remove MapObserver from MapSurface's constructor. ([#200](https://github.com/mapbox/mapbox-maps-android/pull/200))

## Features ✨ and improvements 🏁
* [Annotation plugin] Add symbol cluster support ([#122](https://github.com/mapbox/mapbox-maps-android/pull/122))
* [map] Make public API entry points as MapView and Snapshotter ([#149](https://github.com/mapbox/mapbox-maps-android/pull/149))
* [plugins] Remove PluginRequirementException ([#158](https://github.com/mapbox/mapbox-maps-android/pull/158))
* Use String protocol for passing GeoJSON data  ([#162](https://github.com/mapbox/mapbox-maps-android/pull/162))
* [Annotation plugin] Set default values for annotation option properties to null. ([#173](https://github.com/mapbox/mapbox-maps-android/pull/173))
* [rendering] Schedule non-rendering tasks on Android's scheduler to improve render performance. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [rendering] Query rendered features now work for fill-extrusions when terrain is enabled. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [rendering] Improved terrain rendering performance due to reduction of loaded tiles. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* [doc] Change http link to markdown style in doc  ([#187](https://github.com/mapbox/mapbox-maps-android/pull/187))
* [rendering] Differentiate render tasks and non-render tasks ([#192](https://github.com/mapbox/mapbox-maps-android/pull/192))
* [gestures] Introduce platform-driven drag API to move a map ([#201](https://github.com/mapbox/mapbox-maps-android/pull/201))

## Bug fixes 🐞
* [Annotation plugin] Implement MapStyleObserverPlugin to listen style load event to reload layer and source ([#161](https://github.com/mapbox/mapbox-maps-android/pull/161))
* [gestures] Fix crash if zooming for SDK less than 23 ([#171](https://github.com/mapbox/mapbox-maps-android/pull/171))
* Fix an issue that will result in map not rendering on a device with Ethernet connection. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Fix the crash when running maps on the emulator. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Patch scroll gesture with a pitched camera ([#184](https://github.com/mapbox/mapbox-maps-android/pull/184))
* [locationcomponent] Fix jitter animations if interrupting animations ([#185](https://github.com/mapbox/mapbox-maps-android/pull/185))
* [animation] Fix zero duration animators, fix medium-level animators to use only CameraAnimators ([#198](https://github.com/mapbox/mapbox-maps-android/pull/198))
* [animations] Fix interpolation for flyTo ([#202](https://github.com/mapbox/mapbox-maps-android/pull/202))

## Dependencies
* Update minSdkVersion of the SDK to 21, and bumped okhttp dependency to v4.9.0. ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))
* Update gl-native to v10.0.0-beta.17, common to v10.0.2 ([#176](https://github.com/mapbox/mapbox-maps-android/pull/176))

# 10.0.0-beta.15 - March 5, 2021

## Bugs
* [annotation] Fix text-font issue in annotation plugin. ([#144](https://github.com/mapbox/mapbox-maps-android/pull/144))

## Dependencies
* [gl-native] Update to v10.0.0-beta.16, common to beta.12 ([#137](https://github.com/mapbox/mapbox-maps-android/pull/137))

# 10.0.0-beta.14 - February 24, 2021

## Breaking changes
* [map] Change signature of Map#getElevation from Float to Double [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [map] Fixed text-field strings are now returned as formatted expressions [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [annotation] Rename getAnnotationManger to createAnnotationManager [#105](https://github.com/mapbox/mapbox-maps-android/pull/105)
* [style] GeoJsonSource data property can't be empty [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)

## Features
* [location-component] Add isLocatedAt API to location component plugin [#99](https://github.com/mapbox/mapbox-maps-android/pull/99)
* [snapshot] Introduce interfaces for style events and snapshot result [#124](https://github.com/mapbox/mapbox-maps-android/pull/124)
* [annotation] Process anchor animators correctly [#109](https://github.com/mapbox/mapbox-maps-android/pull/109)
* [annotation] Limit adding style images multiple times for annotations [#118](https://github.com/mapbox/mapbox-maps-android/pull/118)
* [annotation] Add GeoJSONOptions configuration [#79](https://github.com/mapbox/mapbox-maps-android/pull/79)
* [annotation] Show all icons and text from annotation manager by default [#115](https://github.com/mapbox/mapbox-maps-android/pull/115)
* [animation] Add kotlin dsl builder for CameraOptions and java builders for CameraAnimatorOptions and MapAnimationOptions [#90](https://github.com/mapbox/mapbox-maps-android/pull/90)
* [map] Better use of Choreographer inside renderer resulting to smoother map animations [#107](https://github.com/mapbox/mapbox-maps-android/pull/107)
* [gestures] change default interpolator from Decelerate to LinearOutSlowIn [#103](https://github.com/mapbox/mapbox-maps-android/pull/103)

## Bugs
* [compass] Hide the compass on startup when facing north [#116](https://github.com/mapbox/mapbox-maps-android/pull/116)
* [annotation] Change default value of text font for symbols to null [#111](https://github.com/mapbox/mapbox-maps-android/pull/111)
* [map] Remove renderStill from public API [#104](https://github.com/mapbox/mapbox-maps-android/pull/104)
* [style]  Rename reference to style plugin and converting them to style extension [#123](https://github.com/mapbox/mapbox-maps-android/pull/123)
* [annotation] Expose collection of annotations as a List instead of Map [#121](https://github.com/mapbox/mapbox-maps-android/pull/121)
* [camera] Trigger map camera change updates immediately, Fix order of animation callbacks in camera animation plugin [#125](https://github.com/mapbox/mapbox-maps-android/pull/125)

## Dependencies
* [gl-native] update to v10.0.0-beta.15 [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)
* [common] update to v10.0.0-beta.11 [#120](https://github.com/mapbox/mapbox-maps-android/pull/120)

# 10.0.0-beta.13 - February 10, 2021

## Features
* [map] Expose FPS listener [#80](https://github.com/mapbox/mapbox-maps-android/pull/80)
* [annotation] Add convenience color int API [#76](https://github.com/mapbox/mapbox-maps-android/pull/76)
* [annotation] Add convenience bitmap API for symbols [#67](https://github.com/mapbox/mapbox-maps-android/pull/67)
* [annotation] Make getting annotation manager configurable [#47](https://github.com/mapbox/mapbox-maps-android/pull/47)
* [location] Improve the default location provider and improve handling of location updates [#58](https://github.com/mapbox/mapbox-maps-android/pull/58)
* [location] Add OnIndicatorPositionChangedListener and OnIndicatorBearingChangedListener [#56](https://github.com/mapbox/mapbox-maps-android/pull/56)

## Bugs
* [map] allow getSourceAs returning null values, handle cast gracefully [#88](https://github.com/mapbox/mapbox-maps-android/pull/88)
* [animation] remove internal plugin singleton, support multi display maps [#70](https://github.com/mapbox/mapbox-maps-android/pull/70)
* [telemetry] correct versioning of BuildConfig [#65](https://github.com/mapbox/mapbox-maps-android/pull/65)
* [annotation] Fix offset array not working issue [#60](https://github.com/mapbox/mapbox-maps-android/pull/60)
* [plugin] make xml attribute parsers internal [#81](https://github.com/mapbox/mapbox-maps-android/pull/81)

## Dependencies
* [gl-native] update to v10.0.0-beta.14 [#87](https://github.com/mapbox/mapbox-maps-android/pull/87)
* [common] update to v10.0.0-beta.9.1 [#87](https://github.com/mapbox/mapbox-maps-android/pull/87)

# 10.0.0-beta.12 - January 27, 2021

## Announcement

V10 is the latest version of the Mapbox Maps SDK for Android. v10 brings substantial performance improvements, new features like 3D terrain and a more powerful camera, modern technical foundations, and a better developer experience.

To get started with v10, please refer to our [migration guide](https://docs.mapbox.com/android/beta/maps/guides/migrate-to-v10/).

## Known Issues

### Style

* Currently there is no compile-time validation of the Style DSL, exceptions will be thrown in runtime.

### Location

* Location component plugin is still under active development and the interfaces are subject to change.

### 3D Terrain

* 3D Terrain is in an experimental state
* 3D Terrain crashes on specific GPU hardware:
    * Qualcomm Adreno 640

### Other
* Annotation plugin is not feature complete with the old implementation
* Restricting the map to a bounds that includes the antemeridian will result in an invalid jump to the left side of the bounds.
* Known deficiencies with max and min zoom map properties
* An invalid LatLng conversion can occur and produce a native crash
* Native crash when resuming the map in specific situations
* Native crash when performing a camera transition using Map#jumpTo
