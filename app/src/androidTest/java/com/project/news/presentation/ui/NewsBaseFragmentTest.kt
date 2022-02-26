package com.project.news.presentation.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.project.news.R
import com.project.news.hiltUtil.launchFragmentInHiltContainer
import com.project.news.presentation.di.AppModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest
@UninstallModules(AppModule::class)
class NewsBaseFragmentTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltAndroidRule.inject()
    }

    @Test
    fun test_isRecyclerViewShowing(){
        launchFragmentInHiltContainer<NewsBaseFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.recycler))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}