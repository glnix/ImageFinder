package glnix.testjob.imagefinder.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import glnix.testjob.imagefinder.domain.useCase.SearchImageByNameUseCase
import glnix.testjob.imagefinder.domain.useCase.SearchImageByNameUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindSearchByImageNameUseCase(useCaseImpl: SearchImageByNameUseCaseImpl): SearchImageByNameUseCase
}