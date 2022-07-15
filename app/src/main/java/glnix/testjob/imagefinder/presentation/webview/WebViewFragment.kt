package glnix.testjob.imagefinder.presentation.webview

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import glnix.testjob.imagefinder.databinding.FragmentWebviewBinding
import glnix.testjob.imagefinder.presentation.base.ui.BaseFragment

@AndroidEntryPoint
class WebViewFragment : BaseFragment<FragmentWebviewBinding>(FragmentWebviewBinding::inflate) {

    private val args: WebViewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebView()
        loadUrl(args.url)
    }

    private fun initWebView() {
        with(binding.webview) {
            webViewClient  = WebViewClient()
        }
    }

    private fun loadUrl(url: String) {
        binding.webview.loadUrl(url)
    }
}