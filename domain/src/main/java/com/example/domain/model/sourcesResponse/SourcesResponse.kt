package com.example.domain.model.sourcesResponse

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.domain.model.sourcesResponse.Source
import com.google.gson.annotations.SerializedName

@Parcelize
data class SourcesResponse(
    @field:SerializedName("sources")
	val sources: List<Source?>? = null,

    @field:SerializedName("status")
	val status: String? = null,
    @field:SerializedName("message")
	val message: String? = null
) : Parcelable