/**
 * @description: class used to denote base fragment.
 */
package com.project.news.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.news.R
import com.project.news.common.Constants
import com.project.news.data.model.Article
import com.project.news.databinding.FragmentPhoneBaseBinding
import com.project.news.presentation.ui.adapter.NewsListAdapter
import com.project.news.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsBaseFragment @Inject constructor(): Fragment(R.layout.fragment_phone_base),
    NewsListAdapter.ClickListener  {

    private val viewModelObj by activityViewModels<NewsViewModel>()
    private lateinit var binding : FragmentPhoneBaseBinding

    /**
     * @description: lifecycle method.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhoneBaseBinding.bind(view)

        //view-model observer
        val responsiveLiveData = viewModelObj.getAllNews()
        responsiveLiveData.observe(viewLifecycleOwner, {
                updateNewsList(it)
        })
    }

    /**
     * @description: Method used to update recyclerview.
     * @param: List of Article objects
     */
    private fun updateNewsList(articles: List<Article>) {
        // This will pass the ArrayList to our Adapter
        val adapter = NewsListAdapter(articles as ArrayList<Article>, context)
        // Setting the Adapter with the recyclerview
        adapter.setCallBackListener(this)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)
    }

    /**
     * @description: Method used to handle news item click.
     * @param: Article object
     */
    override fun handleClickEvent(article: Article) {
        val newsItemFragment = NewsItemFragment()
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putParcelable(Constants.ARTICLE_KEY, article)
        newsItemFragment.arguments = bundle
        transaction.replace(R.id.fragment_container_view, newsItemFragment).addToBackStack(null)
        transaction.commit()
    }
}