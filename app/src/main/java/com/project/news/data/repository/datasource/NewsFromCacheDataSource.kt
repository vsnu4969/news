/**
 * @description: interface used to fetch values from cache.
 */
package com.project.news.data.repository.datasource

import com.project.news.data.model.News

interface NewsFromCacheDataSource {
    /**
     * @description: Method used to fetch news from cache.
     * @return: News object
     */
    suspend fun getAllNewsFromCache(): News
    /**
     * @description: Method used to save news to cache.
     * @param: News object
     */
    suspend fun saveAllNewsToCache(news: News)
}