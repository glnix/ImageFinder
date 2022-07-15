package glnix.testjob.imagefinder.data.model

import com.google.gson.annotations.SerializedName

data class ImageSearchResult(
    @SerializedName("position") val position: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("original") val original: String,
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("source") val source: String,
    @SerializedName("is_product") val isProduct: Boolean,
)
