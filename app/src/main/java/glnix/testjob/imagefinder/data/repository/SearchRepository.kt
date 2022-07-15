package glnix.testjob.imagefinder.data.repository

import glnix.testjob.imagefinder.data.model.SearchResponse
import retrofit2.Response

interface SearchRepository {

   suspend fun searchImagesByName(imageName: String): Response<SearchResponse>
}