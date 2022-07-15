package glnix.testjob.imagefinder.data.api

import glnix.testjob.imagefinder.BuildConfig
import glnix.testjob.imagefinder.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val SERVICE_TYPE = "isch"

interface SearchApi {
    @GET("/search")
    suspend fun searchImagesByName(
        @Query("q") imageName : String,
        @Query("tbm") serviceType: String = SERVICE_TYPE,
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
    ): Response<SearchResponse>
}
/*

fun <T: Any> Response<T>.map(): List<T> {

}*/
