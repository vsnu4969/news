package com.project.news.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.project.news.data.model.Article
import com.project.news.data.model.Source
import com.project.news.domain.usecase.GetAllNewsUseCase
import com.project.news.repository.FakeNewsRepository
import com.project.news.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var newsViewModel:  NewsViewModel

    @Before
    fun setUp() {
        val fakeNewsRepository = FakeNewsRepository()
        val getAllNewsUseCase = GetAllNewsUseCase(fakeNewsRepository)
        newsViewModel = NewsViewModel(getAllNewsUseCase)
    }

    @Test
    fun getNews_returnsCurrentList() {
        val article = mutableListOf<Article>()
        article.add(
            Article(
                Source("bbc", "BBC"),
            "Vishnu", "title", "description","url", "urlToImg", "date", "content")
        )
        article.add(
            Article(
                Source("bbc", "BBC"),
            "Vishnu", "title", "description","url", "urlToImg", "date", "content")
        )
        val currentList : List<Article> = newsViewModel.getAllNews().getOrAwaitValue()
        assertThat(currentList).isEqualTo(article)
    }
}