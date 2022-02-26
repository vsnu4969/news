package com.project.news.hiltUtil

import com.project.news.common.Constants
import com.project.news.data.remote.NewsApi
import com.project.news.data.repository.NewsRepositoryImpl
import com.project.news.data.repository.datasource.NewsFromCacheDataSource
import com.project.news.data.repository.datasource.NewsFromRemoteDataSource
import com.project.news.data.repository.datasourceimpl.NewsFromCacheDataSourceImpl
import com.project.news.data.repository.datasourceimpl.NewsFromRemoteDataSourceImpl
import com.project.news.domain.repository.NewsRepository
import com.project.news.domain.usecase.GetAllNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    /**
     * @description: Method used for provide news repository instance.
     * @param: NewsFromCacheDataSource
     * @param: NewsFromRemoteDataSource
     * @return: NewsRepository
     */
    @Provides
    fun provideNewsRepository(
        newsFromCacheDataSource: NewsFromCacheDataSource,
        newsFromRemoteDataSource: NewsFromRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsFromRemoteDataSource, newsFromCacheDataSource)
    }

    /**
     * @description: Method used for provide use-case instance.
     * @param: NewsRepository
     * @return: GetAllNewsUseCase
     */
    @Provides
    fun provideGetAllNewsUseCase(
        newsRepository: NewsRepository
    ): GetAllNewsUseCase {
        return GetAllNewsUseCase(newsRepository)
    }

    /**
     * @description: Method used for provide use-case instance.
     * @param: NewsRepository
     * @return: GetAllNewsUseCase
     */
    @Provides
    fun provideRemoteDataSourceImpl(
        newsApi: NewsApi
    ): NewsFromRemoteDataSource {
        return NewsFromRemoteDataSourceImpl(newsApi, Constants.API_KEY_FOR_REMOTE_ACCESS,
            Constants.API_SOURCE_FOR_REMOTE_ACCESS)
    }

    /**
     * @description: Method used for provide data source.
     * @return: NewsFromCacheDataSource
     */
    @Provides
    fun provideCachedDataSourceImpl(): NewsFromCacheDataSource {
        return NewsFromCacheDataSourceImpl()
    }

    /**
     * @description: Method used for provide Api service.
     * @return: NewsApi
     */
    @Provides
    @Singleton
    fun provideApiService(): NewsApi {
        return Retrofit.Builder().baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}