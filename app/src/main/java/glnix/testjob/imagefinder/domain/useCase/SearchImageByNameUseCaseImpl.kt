package glnix.testjob.imagefinder.domain.useCase

import glnix.testjob.imagefinder.data.repository.SearchRepository
import glnix.testjob.imagefinder.domain.model.ImageSearchResultDomain
import glnix.testjob.imagefinder.domain.model.toDomainModel
import javax.inject.Inject

class SearchImageByNameUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository,
) : SearchImageByNameUseCase {
    //Здесь нужна обертка типа sealed Result{ Error, Success},
    // но в данном приложении ошибки обратбатывется через Flow.catch{}
    override suspend fun invoke(searchImageName: String): List<ImageSearchResultDomain> =
        searchRepository.searchImagesByName(searchImageName)
            .body()!!.imagesResults.map { it.toDomainModel() }

}