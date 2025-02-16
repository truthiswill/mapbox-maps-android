import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
  id("com.android.library")
  kotlin("android")
  id("com.jaredsburrows.license")
  id("org.jetbrains.dokka")
}

android {
  compileSdkVersion(AndroidVersions.compileSdkVersion)

  defaultConfig {
    minSdkVersion(AndroidVersions.minSdkVersion)
    targetSdkVersion(AndroidVersions.targetSdkVersion)
    consumerProguardFiles("proguard-rules.pro")
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    testInstrumentationRunnerArguments = mapOf(
      "clearPackageData" to "true"
    )

    if (project.hasProperty("android.injected.invoked.from.ide")) {
      buildConfigField("boolean", "RUN_FROM_IDE", "true")
    } else {
      buildConfigField("boolean", "RUN_FROM_IDE", "false")
    }
  }

  testOptions {
    unitTests.apply {
      isIncludeAndroidResources = true
    }
    animationsDisabled = true
    if (!project.hasProperty("android.injected.invoked.from.ide")) {
      execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }
    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
    }
  }

  sourceSets {
    // limit amount of exposed library resources
    getByName("main").res.srcDirs("src/main/res-public")
  }
}

val buildFromSource: String by project

dependencies {
  api(Dependencies.mapboxBase)
  if (buildFromSource.toBoolean()) {
    api(project(":okhttp"))
  } else {
    api(Dependencies.mapboxOkHttp)
  }

  implementation(Dependencies.mapboxAnnotations)
  api(project(":sdk-base"))
  implementation(project(":module-telemetry"))
  api(project(":extension-style"))
  api(project(":plugin-logo"))
  api(project(":plugin-compass"))
  api(project(":plugin-gestures"))
  api(project(":plugin-attribution"))
  api(project(":plugin-locationcomponent"))
  api(project(":plugin-animation"))
  api(project(":plugin-scalebar"))
  api(project(":plugin-overlay"))
  api(project(":plugin-annotation"))
  api(project(":extension-localization"))
  api(project(":plugin-lifecycle"))
  compileOnly(Dependencies.asyncInflater)
  implementation(Dependencies.kotlin)
  implementation(Dependencies.androidxCoreKtx)
  implementation(Dependencies.androidxAnnotations)
  testImplementation(Dependencies.junit)
  testImplementation(Dependencies.mockk)
  testImplementation(Dependencies.androidxTestCore)
  testImplementation(Dependencies.robolectric)
  testImplementation(Dependencies.robolectricEgl)
  testImplementation(Dependencies.asyncInflater)
  debugImplementation(Dependencies.androidxAppCompat)
  androidTestImplementation(Dependencies.androidxTestRunner)
  androidTestImplementation(Dependencies.androidxTestJUnit)
  androidTestImplementation(Dependencies.androidxRules)
  androidTestImplementation(Dependencies.androidxJUnitTestRules)
  androidTestImplementation(Dependencies.androidxEspresso)
  androidTestImplementation(Dependencies.androidxUiAutomator)
  androidTestUtil(Dependencies.androidxOrchestrator)
}

tasks.withType<DokkaTask>().configureEach {
  dokkaSourceSets {
    configureEach {
      reportUndocumented.set(true)
      // https://github.com/mapbox/mapbox-maps-android/issues/301#issuecomment-712736885
      failOnWarning.set(false)
      if (buildFromSource.toBoolean()) {
        File("upstream-api-doc-list.txt").forEachLine {
          if (!it.startsWith("//")) {
            sourceRoots.from(file("../../$it"))
          }
        }
      }
    }
  }
}

project.apply {
  from("$rootDir/gradle/ktlint.gradle")
  from("$rootDir/gradle/lint.gradle")
  from("$rootDir/gradle/jacoco.gradle")
  from("$rootDir/gradle/sdk-registry.gradle")
  from("$rootDir/gradle/track-public-apis.gradle")
}