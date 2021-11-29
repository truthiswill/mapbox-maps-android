package com.mapbox.maps.plugin.viewport

import com.mapbox.maps.plugin.MapPlugin
import com.mapbox.maps.plugin.viewport.data.ViewportDataSource
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState.Following
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState.Idle
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState.Overview
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState.TransitionToFollowing
import com.mapbox.maps.plugin.viewport.state.ViewportCameraState.TransitionToOverview
import com.mapbox.maps.plugin.viewport.state.ViewportCameraStateChangedObserver
import com.mapbox.maps.plugin.viewport.transition.TransitionEndListener
import com.mapbox.maps.plugin.viewport.transition.ViewportCameraTransition
import com.mapbox.maps.plugin.viewport.transition.ViewportCameraTransitionOptions

interface ViewportPlugin : MapPlugin {

  /**
   * Returns current [ViewportCameraTransition].
   * @see registerViewportCameraStateChangedObserver
   */
  val state: ViewportCameraState

  /**
   * Describes an object that provides desired camera positions to [ViewportPlugin].
   */
  var viewportDataSource: ViewportDataSource

  /**
   * Executes a transition to [Following] state. When started, goes to [TransitionToFollowing]
   * and to the final [Following] when ended. If transition is canceled, state goes to [Idle].
   *
   * The target camera position is obtained with [ViewportDataSource.getViewportData].
   *
   * @param stateTransitionOptionsBlock options that impact the transition animation from
   * the current state to the requested state.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 3500 millis.
   * @param frameTransitionOptionsBlock options that impact the transition animations between
   * viewport frames in the selected state.
   * This refers to camera transition on each [ViewportDataSource] update when [Following] is engaged.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 1000 millis.
   * @param transitionEndListener invoked when transition ends.
   */
  fun requestNavigationCameraToFollowing(
    stateTransitionOptionsBlock: ((ViewportCameraTransitionOptions.Builder).() -> Unit),
    frameTransitionOptionsBlock: ((ViewportCameraTransitionOptions.Builder).() -> Unit),
    transitionEndListener: TransitionEndListener? = null,
  )

  /**
   * Executes a transition to [Following] state. When started, goes to [TransitionToFollowing]
   * and to the final [Following] when ended. If transition is canceled, state goes to [Idle].
   *
   * The target camera position is obtained with [ViewportDataSource.getViewportData].
   *
   * @param stateTransitionOptions options that impact the transition animation from the current state to the requested state.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 3500 millis.
   * @param frameTransitionOptions options that impact the transition animations between viewport frames in the selected state.
   * This refers to camera transition on each [ViewportDataSource] update when [Following] is engaged.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 1000 millis.
   * @param transitionEndListener invoked when transition ends.
   */
  fun requestNavigationCameraToFollowing(
    stateTransitionOptions: ViewportCameraTransitionOptions = DEFAULT_STATE_TRANSITION_OPT,
    frameTransitionOptions: ViewportCameraTransitionOptions = DEFAULT_FRAME_TRANSITION_OPT,
    transitionEndListener: TransitionEndListener? = null,
  )

  /**
   * Executes a transition to [Overview] state. When started, goes to [TransitionToOverview]
   * and to the final [Overview] when ended. If transition is canceled, state goes to [Idle].
   *
   * The target camera position is obtained with [ViewportDataSource.getViewportData].
   *
   * @param stateTransitionOptionsBlock options that impact the transition animation from
   * the current state to the requested state.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 3500 millis.
   * @param frameTransitionOptionsBlock options that impact the transition animations between
   * viewport frames in the selected state.
   * This refers to camera transition on each [ViewportDataSource] update when [Overview] is engaged.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 1000 millis.
   * @param transitionEndListener invoked when transition ends.
   */
  fun requestNavigationCameraToOverview(
    stateTransitionOptionsBlock: ((ViewportCameraTransitionOptions.Builder).() -> Unit),
    frameTransitionOptionsBlock: ((ViewportCameraTransitionOptions.Builder).() -> Unit),
    transitionEndListener: TransitionEndListener? = null,
  )

  /**
   * Executes a transition to [Overview] state. When started, goes to [TransitionToOverview]
   * and to the final [Overview] when ended. If transition is canceled, state goes to [Idle].
   *
   * The target camera position is obtained with [ViewportDataSource.getViewportData].
   *
   * @param stateTransitionOptions options that impact the transition animation from the current state to the requested state.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 3500 millis.
   * @param frameTransitionOptions options that impact the transition animations between viewport frames in the selected state.
   * This refers to camera transition on each [ViewportDataSource] update when [Overview] is engaged.
   * Defaults to [ViewportCameraTransitionOptions.maxDurationMs] equal to 1000 millis.
   * @param transitionEndListener invoked when transition ends.
   */
  fun requestNavigationCameraToOverview(
    stateTransitionOptions: ViewportCameraTransitionOptions = DEFAULT_STATE_TRANSITION_OPT,
    frameTransitionOptions: ViewportCameraTransitionOptions = DEFAULT_FRAME_TRANSITION_OPT,
    transitionEndListener: TransitionEndListener? = null,
  )

  /**
   * If the [state] is [Following] or [Overview],
   * performs an immediate camera transition (a jump, with animation duration equal to `0`)
   * based on the latest data obtained with [ViewportDataSource.getViewportData].
   */
  fun resetFrame()

  /**
   * Immediately goes to [Idle] state canceling all ongoing transitions.
   */
  fun requestNavigationCameraToIdle()

  /**
   * Registers [ViewportCameraStateChangedObserver].
   */
  fun registerViewportCameraStateChangedObserver(
    viewportCameraStateChangedObserver: ViewportCameraStateChangedObserver
  )

  /**
   * Unregisters [ViewportCameraStateChangedObserver].
   */
  fun unregisterViewportCameraStateChangedObserver(
    viewportCameraStateChangedObserver: ViewportCameraStateChangedObserver
  )

  companion object {
    val DEFAULT_STATE_TRANSITION_OPT =
      ViewportCameraTransitionOptions.build { maxDuration(3500L) }
    val DEFAULT_FRAME_TRANSITION_OPT =
      ViewportCameraTransitionOptions.build { maxDuration(1000L) }
  }
}