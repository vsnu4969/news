/**
 * @description: Data class to store news data.
 */
package com.project.news.data.model

import com.google.gson.annotations.SerializedName
import com.project.news.common.Constants

data class News (
    @SerializedName(Constants.API_GET_STATUS)
    val status : String,
    @SerializedName(Constants.API_GET_TOTAL_RESULTS)
    val totalResults :Int,
    @SerializedName(Constants.API_GET_ARTICLES)
    val articles : List<Article>
)

