package glnix.testjob.imagefinder.presentation.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import glnix.testjob.imagefinder.domain.useCase.SearchImageByNameUseCase
import glnix.testjob.imagefinder.presentation.base.ui.BaseViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchImageByNameUseCase: SearchImageByNameUseCase,
) : BaseViewModel() {
    val errorFlow = MutableSharedFlow<Throwable>()
    val progressFlow = MutableSharedFlow<Boolean>()

    val searchQuery = MutableSharedFlow<String>()
    val resultsFlow = searchQuery
        .onEach { progressFlow.emit(true) }
        .mapLatest { query ->
            searchImageByNameUseCase(query)
        }.onEach { progressFlow.emit(false) }
        .catch {
            progressFlow.emit(false)
            errorFlow.emit(it) }
        .stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(5000),
            initialValue = emptyList()
        )
}

