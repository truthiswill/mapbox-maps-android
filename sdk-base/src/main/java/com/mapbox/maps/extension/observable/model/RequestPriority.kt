package com.mapbox.maps.extension.observable.model

import com.google.gson.annotations.SerializedName

/**
 * Describes priority for request object.
 */
enum class RequestPriority {
  /** Regular priority. */
  @SerializedName("regular")
  REGULAR,

  /** low priority. */
  @SerializedName("low")
  LOW
}