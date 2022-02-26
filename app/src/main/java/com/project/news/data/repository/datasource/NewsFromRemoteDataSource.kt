/**
 * @description: interface used to fetch values from remote.
 */
package com.project.news.data.repository.datasource

import com.project.news.data.model.News
import retrofit2.Response

interface NewsFromRemoteDataSource {
    /**
     * @description: Method used to fetch news from remote.
     * @return: server response
     */
    suspend fun getAllNewsFromRemote(): Response<News>
}