package glnix.testjob.imagefinder.data.repository

import glnix.testjob.imagefinder.data.api.SearchApi
import glnix.testjob.imagefinder.data.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApi: SearchApi,
) : SearchRepository {

    override suspend fun searchImagesByName(imageName: String): Response<SearchResponse> =
        searchApi.searchImagesByName(imageName)
}