/**
 * @description: class used as use-case.
 */
package com.project.news.domain.usecase

import com.project.news.data.model.Article
import com.project.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    /**
     * @description: Method used to execute the news fetching.
     * @return: List of Article objects.
     */
    suspend fun execute(): List<Article> = newsRepository.getAllNews()
}