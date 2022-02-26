/**
 * @description: class used for showing news item.
 */
package com.project.news.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.project.news.R
import com.project.news.common.Constants
import com.project.news.data.model.Article
import com.project.news.databinding.FragmentNewsItemBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsItemFragment : Fragment(R.layout.fragment_news_item) {

    private lateinit var binding: FragmentNewsItemBinding
    lateinit var article: Article

    /**
     * @description: lifecycle method.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNewsItemBinding.bind(view)
        article = (arguments!!.getParcelable(Constants.ARTICLE_KEY))!!

            binding.titleNews.text = article.title
            binding.descriptionTextView.text = article.content
            binding.titleNewsDate.text = article.publishedAt
            binding.newsLink.text = getString(R.string.detailed_information_text, article.url)

            Picasso .with(context)
                .load(article.urlToImage)
                .placeholder(R.drawable.fail)
                .resize(Constants.NEWS_ITEM_IMG_SIZE,Constants.NEWS_ITEM_IMG_SIZE)
                .into(binding.imageView)

    }
}