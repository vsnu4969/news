/**
 * @description: class used for showing news items.
 */
package com.project.news.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.news.R
import com.project.news.common.Constants
import com.project.news.data.model.Article
import com.project.news.databinding.NewsListItemBinding
import com.squareup.picasso.Picasso

class NewsListAdapter(
    private val list: ArrayList<Article>,
    private val context: Context?,
) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    private lateinit var binding: NewsListItemBinding
    private lateinit var mClickListener : ClickListener

    /**
     * @description: lifecycle method recyclerview.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_item, parent, false)
        binding = NewsListItemBinding.bind(view)
        return ViewHolder(binding)
    }

    /**
     * @description: lifecycle method recyclerview.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.title.text = list[position].title
        binding.description.text = list[position].description
        binding.date.text = list[position].publishedAt
        binding.news.text = list[position].source.name
        Picasso .with(context)
            .load(list[position].urlToImage)
            .placeholder(R.drawable.fail)
            .resize(Constants.RECYCLER_VIEW_IMG_SIZE,Constants.RECYCLER_VIEW_IMG_SIZE)
            .into(binding.image)


        binding.parentItem.setOnClickListener{
            mClickListener.handleClickEvent(list[position])
        }

    }

    /**
     * @description: Method used to handle click action.
     */
    interface ClickListener {
        fun handleClickEvent(article: Article)
    }

    /**
     * @description: lifecycle method recyclerview.
     */
    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * @description: method used to set listener.
     */
    fun setCallBackListener(listener: ClickListener) {
        mClickListener = listener
    }

    /**
     * @description: class used as view-holder.
     */
    class ViewHolder(binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root)
}