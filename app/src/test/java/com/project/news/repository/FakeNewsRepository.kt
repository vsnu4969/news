package com.project.news.repository

import com.project.news.data.model.Article
import com.project.news.data.model.Source
import com.project.news.domain.repository.NewsRepository

class FakeNewsRepository : NewsRepository {

    private val article = mutableListOf<Article>()

    init {
        article.add(Article(Source("bbc", "BBC"),
            "Vishnu", "title", "description","url", "urlToImg", "date", "content"))
        article.add(Article(Source("bbc", "BBC"),
            "Vishnu", "title", "description","url", "urlToImg", "date", "content"))
    }

    override suspend fun getAllNews(): List<Article> {
        return article
    }


}