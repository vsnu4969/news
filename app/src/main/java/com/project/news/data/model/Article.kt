/**
 * @description: Data class to store news Article data.
 */
package com.project.news.data.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.project.news.common.Constants

@SuppressLint("ParcelCreator")
data class Article(
    @SerializedName(Constants.API_GET_SOURCE)
    val source: Source,
    @SerializedName(Constants.API_GET_AUTHOR)
    val author: String?,
    @SerializedName(Constants.API_GET_TITLE)
    val title: String?,
    @SerializedName(Constants.API_GET_DESCRIPTION)
    val description: String?,
    @SerializedName(Constants.API_GET_URL)
    val url: String?,
    @SerializedName(Constants.API_GET_URL_TO_IMG)
    val urlToImage: String?,
    @SerializedName(Constants.API_GET_PUBLISHED_AT)
    val publishedAt: String?,
    @SerializedName(Constants.API_GET_CONTENT)
    val content: String?
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        //No need to write to parcel for now.
    }
}





