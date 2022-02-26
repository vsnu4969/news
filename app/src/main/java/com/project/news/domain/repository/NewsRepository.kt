/**
 * @description: interface used as repository.
 */
package com.project.news.domain.repository

import com.project.news.data.model.Article

interface NewsRepository {
    /**
     * @description: Method used as repository implementation.
     * @return: List of Article objects.
     */
    suspend fun getAllNews(): List<Article>
}