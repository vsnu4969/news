/**
 * @description: class used as repository implementation.
 */
package com.project.news.data.repository

import com.project.news.common.Constants
import com.project.news.data.model.Article
import com.project.news.data.model.News
import com.project.news.data.repository.datasource.NewsFromCacheDataSource
import com.project.news.data.repository.datasource.NewsFromRemoteDataSource
import com.project.news.domain.repository.NewsRepository
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsFromRemoteDataSource: NewsFromRemoteDataSource,
    private val newsFromCacheDataSource: NewsFromCacheDataSource
): NewsRepository {

    /**
     * @description: Method used to get all news.
     * @return: list of Article object
     */
    override suspend fun getAllNews(): List<Article> {
        val news =  getNews()
        val articleList = news.articles

        //Articles sorted by date
        articleList.sortedBy {
            it.publishedAt
        }
        return articleList
    }

    /**
     * @description: Method used to fetch News object from cache/remote.
     * @return: News object
     */
    private suspend fun getNews(): News {
        var news : News = newsFromCacheDataSource.getAllNewsFromCache()
        Timber.i( "getNews total results = ${news.totalResults}")
        if (news.totalResults == Constants.DEFAULT_TOTAL_RESULTS) {
            try {
                val response = newsFromRemoteDataSource.getAllNewsFromRemote()
                val body = response.body()
                body?.let {
                    news = it
                }
                newsFromCacheDataSource.saveAllNewsToCache(news)
            } catch (exception: Exception) {
                Timber.e(exception)
            }
        }
        return news
    }
}