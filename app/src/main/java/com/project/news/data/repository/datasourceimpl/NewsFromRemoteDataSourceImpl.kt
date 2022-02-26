/**
 * @description: class used to fetch values from remote.
 */
package com.project.news.data.repository.datasourceimpl

import com.project.news.data.model.News
import com.project.news.data.remote.NewsApi
import com.project.news.data.repository.datasource.NewsFromRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class NewsFromRemoteDataSourceImpl @Inject constructor(private val newsApi: NewsApi,
                                                       private val apiKey: String,
                                                       private val source: String) :
    NewsFromRemoteDataSource {

    /**
     * @description: Method used to fetch news from remote.
     * @return: server response
     */
    override suspend fun getAllNewsFromRemote(): Response<News> {
        return newsApi.getTopNews(source,apiKey)
    }
}