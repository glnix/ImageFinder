package glnix.testjob.imagefinder.domain.useCase

import glnix.testjob.imagefinder.domain.model.ImageSearchResultDomain

interface SearchImageByNameUseCase {

    suspend operator fun invoke(searchImageName: String): List<ImageSearchResultDomain>
}