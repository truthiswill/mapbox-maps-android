package com.mapbox.maps.renderer

import android.view.Surface
import com.mapbox.common.ShadowLogger
import com.mapbox.maps.renderer.egl.EGLCore
import io.mockk.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@RunWith(RobolectricTestRunner::class)
@Config(shadows = [ShadowLogger::class])
@LooperMode(LooperMode.Mode.PAUSED)
class MapboxRenderThreadTest {

  private lateinit var mapboxRenderThread: MapboxRenderThread
  private lateinit var mapboxRenderer: MapboxRenderer
  private lateinit var eglCore: EGLCore
  private lateinit var renderHandlerThread: RenderHandlerThread
  private val waitTime = 200L

  fun mockValidSurface() {
    val surface = mockk<Surface>()
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
  }

  fun mockCountdownRunnable(latch: CountDownLatch) = mockk<Runnable>(relaxUnitFun = true).also {
    every { it.run() } answers { latch.countDown() }
  }

  @Before
  fun setUp() {
    mapboxRenderer = mockk(relaxUnitFun = true)
    eglCore = mockk(relaxed = true)
    renderHandlerThread = RenderHandlerThread()
    mapboxRenderThread = MapboxRenderThread(
      mapboxRenderer,
      renderHandlerThread,
      eglCore
    ).apply {
      renderHandlerThread.start()
    }
  }

  @After
  fun cleanup() {
    clearAllMocks()
    renderHandlerThread.stop()
  }

  @Test
  fun onSurfaceCreatedTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceCreated() } answers { latch.countDown() }
    mockValidSurface()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verify {
      mapboxRenderer.onSurfaceCreated()
      eglCore.makeNothingCurrent()
      mapboxRenderer.onSurfaceChanged(1, 1)
    }
  }

  @Test
  fun onSurfaceCreatedNotNativeSupportedTest() {
    val latch = CountDownLatch(1)
    val surface = mockk<Surface>()
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns false
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    verify(exactly = 0) {
      mapboxRenderer.onSurfaceCreated()
      mapboxRenderer.onSurfaceChanged(1, 1)
    }
  }

  @Test
  fun onSurfaceSizeChangedIndeedTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceCreated() } answers { latch.countDown() }
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.onSurfaceSizeChanged(2, 2)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verify {
      mapboxRenderer.onSurfaceCreated()
      mapboxRenderer.onSurfaceChanged(1, 1)
      mapboxRenderer.onSurfaceChanged(2, 2)
    }
  }

  @Test
  fun onSurfaceSizeChangedSameSizeTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceCreated() } answers { latch.countDown() }
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.onSurfaceSizeChanged(1, 1)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verify {
      mapboxRenderer.onSurfaceCreated()
      mapboxRenderer.onSurfaceChanged(1, 1)
    }
  }

  @Test
  fun onSurfaceWithActivityDestroyedAfterSurfaceTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceDestroyed() } answers { latch.countDown() }
    val surface = mockk<Surface>(relaxUnitFun = true)
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    mapboxRenderThread.onSurfaceDestroyed()
    mapboxRenderThread.destroy()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    assert(!mapboxRenderThread.eglPrepared)
    verify { mapboxRenderer.onSurfaceDestroyed() }
    assert(!renderHandlerThread.started)
  }

  @Test
  fun onSurfaceWithActivityDestroyedBeforeSurfaceTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceDestroyed() } answers { latch.countDown() }
    val surface = mockk<Surface>(relaxUnitFun = true)
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    mapboxRenderThread.destroy()
    mapboxRenderThread.onSurfaceDestroyed()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    assert(!mapboxRenderThread.eglPrepared)
    verify { mapboxRenderer.onSurfaceDestroyed() }
    assert(!renderHandlerThread.started)
  }

  @Test
  fun onSurfaceDestroyedWithRenderCallAfterTestSurfaceView() {
    mapboxRenderer = mockk<MapboxSurfaceRenderer>(relaxed = true)
    mapboxRenderThread = MapboxRenderThread(
      mapboxRenderer,
      renderHandlerThread,
      eglCore
    ).apply {
      renderHandlerThread.start()
    }
    val surface = mockk<Surface>(relaxUnitFun = true)
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    mapboxRenderThread.onSurfaceDestroyed()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    // we do not destroy native renderer if it's stop and not destroy
    verify(exactly = 0) {
      mapboxRenderer.onSurfaceDestroyed()
    }
    // EGL should still be prepared
    assert(mapboxRenderThread.eglPrepared)
    // EGL surface should be null
    Assert.assertNull(mapboxRenderThread.eglSurface)
  }

  @Test
  fun onSurfaceDestroyedWithRenderCallAfterTestTextureView() {
    mapboxRenderer = mockk<MapboxTextureViewRenderer>(relaxed = true)
    mapboxRenderThread = MapboxRenderThread(
      mapboxRenderer,
      renderHandlerThread,
      eglCore
    ).apply {
      renderHandlerThread.start()
    }
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceDestroyed() } answers { latch.countDown() }
    val surface = mockk<Surface>(relaxUnitFun = true)
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    mapboxRenderThread.onSurfaceDestroyed()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    // we do destroy native renderer if it's stop (for texture renderer)
    verify(exactly = 1) {
      mapboxRenderer.onSurfaceDestroyed()
    }
    // EGL should not be prepared
    assert(!mapboxRenderThread.eglPrepared)
    // EGL surface should be null
    Assert.assertNull(mapboxRenderThread.eglSurface)
  }

  @Test
  fun onDrawFrameSeparateRequestRender() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    // one swap buffer for surface creation, two for not squashed render requests
    verify(exactly = 3) {
      eglCore.swapBuffers(any())
    }
    // make EGL context current only once when creating surface
    verify(exactly = 1) {
      eglCore.makeNothingCurrent()
    }
  }

  @Test
  fun onDrawFrameSquashedRequestRender() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    // one swap buffer for surface creation, 2 render requests squash in one swap buffers call
    verify(exactly = 2) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun setMaximumFpsTest() {
    mapboxRenderThread.setMaximumFps(30)
    assert(mapboxRenderThread.renderTimeNs.get() == 33333333L)
  }

  @Test
  fun pauseTest() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.pause()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    // one swap buffer for surface creation, one request render after pause is omitted
    verify(exactly = 2) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun resumeTestWithRequestRenderAtPause() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.pause()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.resume()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    // render requests after pause do not swap buffer, we do it on resume if needed once
    verify(exactly = 4) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun resumeTestWithoutRequestRenderAtPause() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.pause()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.resume()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    // no actual swap buffer after resume as no calls were done after pause
    verify(exactly = 3) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun destroyTest() {
    mapboxRenderThread.destroy()
    assert(!renderHandlerThread.started)
  }

  @Test
  fun queueRenderEventTest() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    val runnable = mockCountdownRunnable(latch)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.queueRenderEvent(runnable)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    assert(mapboxRenderThread.renderEventQueue.isEmpty())
    verify { runnable.run() }
    // one swap buffer from surface creation, one for custom event
    verify(exactly = 2) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun queueEventTestWithAwaitVsync() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    val runnable = mockk<Runnable>(relaxUnitFun = true)
    mapboxRenderThread.awaitingNextVsync.set(true)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.queueEvent(runnable)
    Assert.assertEquals(1, mapboxRenderThread.eventQueue.size)
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    latch.await(waitTime, TimeUnit.MILLISECONDS)
    assert(mapboxRenderThread.eventQueue.isEmpty())
    verify { runnable.run() }
    // one swap buffer from surface creation, one for custom event
    verify(exactly = 2) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun queueEventTestWithoutAwaitVsync() {
    val latch = CountDownLatch(1)
    mockValidSurface()
    val runnable = mockCountdownRunnable(latch)
    mapboxRenderThread.awaitingNextVsync.set(false)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.queueEvent(runnable)
    Assert.assertEquals(0, mapboxRenderThread.eventQueue.size)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    assert(mapboxRenderThread.eventQueue.isEmpty())
    verify { runnable.run() }
    // one swap buffer from surface creation and no from custom event
    verify(exactly = 1) {
      eglCore.swapBuffers(any())
    }
  }

  @Test
  fun fpsListenerTest() {
    val latch = CountDownLatch(2)
    val listener = mockk<OnFpsChangedListener>(relaxUnitFun = true)
    val surface = mockk<Surface>()
    every { listener.onFpsChanged(any()) } answers { latch.countDown() }
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    mapboxRenderThread.fpsChangedListener = listener
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()
    mapboxRenderThread.requestRender()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    mapboxRenderThread.requestRender()
    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verify(exactly = 2) {
      listener.onFpsChanged(any())
    }
  }

  @Test
  fun surfaceCreatedCalledBeforeActivityStartTest() {
    val latch = CountDownLatch(1)
    every { mapboxRenderer.onSurfaceCreated() } answers { latch.countDown() }
    val surface = mockk<Surface>()
    every { surface.isValid } returns true
    every { eglCore.eglStatusSuccess } returns true
    every { eglCore.createWindowSurface(any()) } returns mockk(relaxed = true)
    mapboxRenderThread.paused = true
    mapboxRenderThread.onSurfaceCreated(surface, 1, 1)
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verify { mapboxRenderer.onSurfaceCreated() }
    // EGL should be prepared
    assert(mapboxRenderThread.eglPrepared)
  }

  @Test
  fun snapshotsAreTakenAfterDrawAndBeforeSwapBuffers() {
    val latch = CountDownLatch(3)

    mockValidSurface()

    val runnable = mockCountdownRunnable(latch)
    val runnable2 = mockCountdownRunnable(latch)
    val runnable3 = mockCountdownRunnable(latch)
    Shadows.shadowOf(renderHandlerThread.handler?.looper).pause()

    mapboxRenderThread.queueSnapshot(runnable)
    mapboxRenderThread.queueSnapshot(runnable2)
    mapboxRenderThread.queueSnapshot(runnable3)

    Shadows.shadowOf(renderHandlerThread.handler?.looper).idle()
    if (!latch.await(waitTime, TimeUnit.MILLISECONDS)) {
      throw TimeoutException()
    }
    verifyOrder {
      mapboxRenderer.onDrawFrame()
      runnable.run()
      runnable2.run()
      runnable3.run()
      eglCore.swapBuffers(any())
    }
  }
}