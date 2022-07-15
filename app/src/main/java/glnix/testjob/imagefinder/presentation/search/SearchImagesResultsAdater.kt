package glnix.testjob.imagefinder.presentation.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import glnix.testjob.imagefinder.databinding.ViewImageResultBinding
import glnix.testjob.imagefinder.domain.model.ImageSearchResultDomain

class SearchImagesResultsAdapter(private val imageItemClickListener: (ImageSearchResultDomain) -> Unit) :
    RecyclerView.Adapter<SearchImagesResultsAdapter.ImageSearchResultViewHolder>() {

    private val resultSearchImageList = mutableListOf<ImageSearchResultDomain>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageSearchResultViewHolder {
        val binding =
            ViewImageResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageSearchResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageSearchResultViewHolder, position: Int) {
        val item = resultSearchImageList[position]
        Glide.with(holder.itemView.context)
            .load(item.thumbnail)
            .centerInside()
            .into(holder.binding.resultImage)
        holder.itemView.setOnClickListener { imageItemClickListener.invoke(item) }
    }

    override fun getItemCount(): Int = resultSearchImageList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newSearchResult: List<ImageSearchResultDomain>) {
        resultSearchImageList.clear()
        resultSearchImageList.addAll(newSearchResult)
        notifyDataSetChanged()
    }

    inner class ImageSearchResultViewHolder(val binding: ViewImageResultBinding) :
        RecyclerView.ViewHolder(binding.root)

}