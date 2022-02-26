/**
 * @description: API class to fetch server response.
 */
package com.project.news.data.remote

import com.project.news.common.Constants
import com.project.news.data.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    /**
     * @description: Method used to fetch latest news from remote.
     */
    @GET(Constants.API_TOP_HEAD_LINES)
    suspend fun getTopNews(@Query(Constants.API_SOURCES)source : String,
                           @Query(Constants.API_KEY) apiKey : String)
    : Response<News>
}