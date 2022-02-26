/**
 * @description: class used to fetch values from cache.
 */
package com.project.news.data.repository.datasourceimpl

import com.project.news.common.Constants
import com.project.news.data.model.News
import com.project.news.data.repository.datasource.NewsFromCacheDataSource
import javax.inject.Inject

class NewsFromCacheDataSourceImpl @Inject constructor(): NewsFromCacheDataSource {

    private var news = News(Constants.DEFAULT_STATUS,Constants.DEFAULT_TOTAL_RESULTS, emptyList())

    /**
     * @description: Method used to fetch news from cache.
     * @return: News object
     */
    override suspend fun getAllNewsFromCache(): News {
        return news
    }

    /**
     * @description: Method used to save news to cache.
     * @param: News object
     */
    override suspend fun saveAllNewsToCache(news: News) {
        this.news = news
    }
}