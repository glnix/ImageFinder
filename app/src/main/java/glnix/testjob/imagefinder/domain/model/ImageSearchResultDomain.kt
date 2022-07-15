package glnix.testjob.imagefinder.domain.model

import android.os.Parcelable
import glnix.testjob.imagefinder.data.model.ImageSearchResult
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ImageSearchResultDomain(
    val position: Int,
    val thumbnail: String,
    val original: String,
    val title: String,
    val link: String,
    val source: String,
    val isProduct: Boolean,
): Parcelable

fun ImageSearchResult.toDomainModel(): ImageSearchResultDomain =
    ImageSearchResultDomain(
        position = position,
        thumbnail = thumbnail,
        original = original,
        title = title,
        link = link,
        source = source,
        isProduct = isProduct,
    )