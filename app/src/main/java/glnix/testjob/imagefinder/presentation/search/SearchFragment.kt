package glnix.testjob.imagefinder.presentation.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import glnix.testjob.imagefinder.R
import glnix.testjob.imagefinder.databinding.FragmentSearchBinding
import glnix.testjob.imagefinder.domain.model.ImageSearchResultDomain
import glnix.testjob.imagefinder.presentation.base.ui.BaseFragment
import glnix.testjob.imagefinder.presentation.textChanges
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val adapter = SearchImagesResultsAdapter() { item ->
        navigateToFullScreen(item)
    }

    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeFlows()
    }

    private fun initViews() {
        with(binding) {
            imagesResultsRv.layoutManager = GridLayoutManager(requireContext(), 3)
            imagesResultsRv.adapter = adapter
            toolbar.toolbarInput.textChanges()
                .debounce(timeoutMillis = 500)
                .filter { it.toString().isNotBlank() }
                .mapLatest { searchQuery ->
                    viewModel.searchQuery.emit(searchQuery.toString())
                }
                .launchIn(lifecycleScope)
        }
    }

    private fun observeFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.resultsFlow.collect { resultlList ->
                adapter.updateList(resultlList)
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.progressFlow.collect {
                switchSearchProgress(it)
            }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.errorFlow.collect {
                Toast.makeText(
                    requireContext(),
                    it.message ?: getString(R.string.default_error_text),
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }

    private fun switchSearchProgress(isEnabled: Boolean) {
        binding.toolbar.progressSearch.isVisible = isEnabled
    }

    private fun navigateToFullScreen(item: ImageSearchResultDomain) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToFullScreenFragment(
                item
            )
        )
    }
}
