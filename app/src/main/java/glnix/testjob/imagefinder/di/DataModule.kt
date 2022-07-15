package glnix.testjob.imagefinder.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import glnix.testjob.imagefinder.data.repository.SearchRepository
import glnix.testjob.imagefinder.data.repository.SearchRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}