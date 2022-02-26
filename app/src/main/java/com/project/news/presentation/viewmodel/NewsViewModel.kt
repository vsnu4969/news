/**
 * @description: Class used to denote the view-model.
 */
package com.project.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.project.news.domain.usecase.GetAllNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getAllNewsUseCase: GetAllNewsUseCase)
    : ViewModel() {

    /**
     * @description: Method used to observe all news.
     */
    fun getAllNews() = liveData {
        val articleList = getAllNewsUseCase.execute()
        emit(articleList)
    }
}