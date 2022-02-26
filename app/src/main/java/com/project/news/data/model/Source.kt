/**
 * @description: Data class to store source Article data.
 */
package com.project.news.data.model

import com.google.gson.annotations.SerializedName
import com.project.news.common.Constants

class Source (
    @SerializedName(Constants.API_GET_ID)
    val id: String,
    @SerializedName(Constants.API_GET_NAME)
    val name: String
)