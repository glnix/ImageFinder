package glnix.testjob.imagefinder.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("images_results") val imagesResults: List<ImageSearchResult>
)