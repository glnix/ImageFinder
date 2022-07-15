package glnix.testjob.imagefinder.presentation.full

import android.content.ActivityNotFoundException
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import glnix.testjob.imagefinder.databinding.FragmentFullBinding
import glnix.testjob.imagefinder.presentation.base.ui.BaseFragment

@AndroidEntryPoint
class FullFragment : BaseFragment<FragmentFullBinding>(FragmentFullBinding::inflate) {

    private val viewModel: FullViewModel by viewModels()
    private val args: FullFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        Glide.with(requireContext())
            .load(args.searchItem.original)
            .fitCenter()
            .into(binding.imageFullScrfeen)
    }

    private fun initViews() {
        binding.buttonOpenInChromeTab.setOnClickListener {
            //Если установлен Chrome, откроем в CustomChromeTabs, ессли нет, то в Webview
            val actionChromeTabs = FullFragmentDirections.actionToWeb(args.searchItem.link)
            val actionWebview = FullFragmentDirections.actionToWebview(args.searchItem.link)
            try {
                findNavController().navigate(actionChromeTabs)
            } catch (e: ActivityNotFoundException) {
                findNavController().navigate(actionWebview)
            }
        }
    }

}